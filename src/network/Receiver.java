import java.net.*;
import java.util.*;

public class Receiver {
    static final int PORT = 9876; // 수신 측 포트
    static final int LOSS_SIMULATION = 3; // 3번패킷 3중반복
    static final int TIMEOUT_SIMULATION = 10; // 10번 패킷 누락

    DatagramSocket socket;
    Set<Integer> receivedPackets = new TreeSet<>(); // 수신된 패킷 번호 관리
    boolean duplicationFlag = false;
    boolean timeoutFlag = false;

    public Receiver() throws Exception {
        socket = new DatagramSocket(PORT);
        System.out.println("Receiver started on port " + PORT);
    }

    public void receivePackets() throws Exception {
        byte[] buffer = new byte[1024];

        while (true) {
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);

            // 수신된 패킷 처리
            String message = new String(packet.getData(), 0, packet.getLength());
            int packetNumber = Integer.parseInt(message.split(" ")[1]);
            System.out.println("Received: " + message);

            // 특정 패킷 누락 시뮬레이션
            if (packetNumber == LOSS_SIMULATION && !duplicationFlag) {
                duplicationFlag=true;
                System.out.println("의도적 3중반복 ACK 발생" + packetNumber);
                for(int i=0; i<2;i++){
                    sendACK(3,packet.getAddress(),packet.getPort());
                }
            }

            if(packetNumber == TIMEOUT_SIMULATION && !timeoutFlag){
                // 10번 패킷 의도적 무시
                timeoutFlag = true;
                continue;
            }

            // 수신된 패킷 저장
            receivedPackets.add(packetNumber);

            // ACK 전송
            sendACK(packetNumber, packet.getAddress(), packet.getPort());
        }
    }

    private void sendACK(int packetNumber, InetAddress address, int port) throws Exception {
        String ackMessage = "ACK " + packetNumber;
        byte[] ackBuffer = ackMessage.getBytes();
        DatagramPacket ackPacket = new DatagramPacket(ackBuffer, ackBuffer.length, address, port);
        socket.send(ackPacket);
        System.out.println("Sent: " + ackMessage);
    }

    public static void main(String[] args) throws Exception {
        Receiver receiver = new Receiver();
        receiver.receivePackets();
    }
}
