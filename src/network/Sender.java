import java.net.*;
import java.util.*;

public class Sender {
    static final int TIMEOUT = 10000; // 패킷 타임아웃 시간 (ms)
    static final int MAX_PACKET = 20; // 총 패킷 수
    static final int RECEIVER_PORT = 9876; // 수신 측 포트
    static final int DUP_ACK_THRESHOLD = 3; // 중복 ACK 발생 임계치

    int cwnd = 1; // 혼잡 윈도우 크기
    int ssthresh = 4; // 임계값
    int base = 0; // ACK를 기다리는 패킷 번호
    int dupACKCount = 1; // 중복 ACK 카운트
    Map<Integer, Timer> packetTimers = new HashMap<>(); // 패킷별 타이머 관리
    DatagramSocket socket;
    InetAddress receiverAddress;
    boolean[] acked = new boolean[MAX_PACKET];
    boolean[] sent = new boolean[MAX_PACKET];

    public Sender(String receiverHost) throws Exception {
        socket = new DatagramSocket();
        receiverAddress = InetAddress.getByName(receiverHost);
    }

    public void sendPackets() throws Exception {
        while (base < MAX_PACKET) {
            // 혼잡 윈도우 크기만큼 패킷 전송
            for (int i = base; i < base + cwnd && i<MAX_PACKET&&!sent[i] && !acked[i]; i++) {
                if (!packetTimers.containsKey(i)) {
                    sendPacket(i);
                }
            }
            // ACK 수신 대기
            receiveACK();
            // 1초 대기
            Thread.sleep(1000);
        }

        System.out.println("All packets sent!");
        socket.close();
    }

    private void sendPacket(int packetNumber) throws Exception {
        String message = "Packet " + packetNumber;
        byte[] buffer = message.getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, receiverAddress, RECEIVER_PORT);
        socket.send(packet);
        System.out.println("Sent: " + message);
        sent[packetNumber] = true;
        // 패킷 타이머 시작
        startPacketTimer(packetNumber);
    }

    private void startPacketTimer(int packetNumber) {
        if(packetTimers.containsKey(packetNumber)){
            return;
        }
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    handleTimeout(packetNumber);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, TIMEOUT);

        System.out.println("put timer = " + packetNumber);
        packetTimers.put(packetNumber, timer);
    }

    private void stopPacketTimer(int packetNumber) {
        Timer timer = packetTimers.remove(packetNumber);
        if (timer != null) {
            timer.cancel();
            System.out.println("Stopped timer for Packet " + packetNumber);
        }
    }

    private void receiveACK() {
        try {
            byte[] buffer = new byte[1024];
            DatagramPacket ackPacket = new DatagramPacket(buffer, buffer.length);
            socket.receive(ackPacket);

            String ackMessage = new String(ackPacket.getData(), 0, ackPacket.getLength());
            System.out.println("Received: " + ackMessage);

            if (ackMessage.startsWith("ACK")) {
                int ack = Integer.parseInt(ackMessage.split(" ")[1]);
                acked[ack] = true;
                stopPacketTimer(ack);
                if (ack >= base) {
                    base = ack + 1;
                    adjustCwndAfterNormalACK();
                } else {
                    dupACKCount++;
                    if (dupACKCount == DUP_ACK_THRESHOLD) {
                        handleDupACK();
                    }
                }
            }
        } catch (SocketTimeoutException e) {
            System.out.println("Timeout while waiting for ACK.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleTimeout(int packetNumber) throws Exception {
        ssthresh = Math.max(cwnd / 2, 1);
        cwnd = 1;
        System.out.println(packetNumber+"번 패킷 타임아웃 발생");
        System.out.println("재전송 시도");
        sendPacket(packetNumber); // 재전송
        System.out.println("새로운 임계값: "+ssthresh + ", cwnd: " + cwnd);
    }

    private void handleDupACK() {
        ssthresh = Math.max((cwnd / 2) + 3, 1);
        cwnd = ssthresh;
        System.out.println(base-1+"패킷에서"+"3 Duplicate ACK 발생");
        System.out.println("새로운 임계값: "+ssthresh + ", cwnd: " + cwnd);

        try {
            System.out.println("재전송 시도");
            sendPacket(base-1); // 재전송
            dupACKCount=0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void adjustCwndAfterNormalACK() {
        if (cwnd < ssthresh) { // Slow Start
            cwnd *= 2;
            System.out.println("Slow Start x2 CWND : " + cwnd);
        } else { // Congestion Avoidance
            cwnd += 1;
            System.out.println("Congestion Avoidance +1 CWND : " + cwnd);
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("Usage: java Sender <Receiver IP>");
            return;
        }
        Sender sender = new Sender(args[0]);
        sender.sendPackets();
    }
}
