package three;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 카드정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 3333 을 생각해보자... 3+3 을 하고 6과 3을 더하는 것과 3과3을 더해서 다시 6을 만드는게 더 좋다.
        PriorityQueue<Long> pq = new PriorityQueue<>();

        int n = Integer.parseInt(st.nextToken());
        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(Long.parseLong(st.nextToken()));
        }
        long result = 0;

        while(pq.size() > 1){
            long sum = pq.poll() + pq.poll();
            pq.add(sum);
            result += sum;
        }

        bw.write(result+"\n");
        bw.flush();
        bw.close();
    }
}
