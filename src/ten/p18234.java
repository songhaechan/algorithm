package ten;

import java.io.*;
import java.util.*;

public class p18234 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int[] carrot = new int[N];
        int[] w = new int[N];
        int[] p = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }
        PriorityQueue<Node> que = new PriorityQueue<>();
        long ans = 0;
        for (int i = 0; i < N; i++) {
            que.offer(new Node(w[i],p[i]));
        }

        long cnt = 0;

        while(!que.isEmpty()){
            Node now = que.poll();
            ans += (T-N+cnt)*now.p + now.w;
            cnt++;
        }
        sb.append(ans);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    static class Node implements Comparable<Node>{
        int w;
        int p;

        public Node(int curP, int p) {
            this.w = curP;
            this.p = p;
        }

        @Override
        public int compareTo(Node o) {
            return this.p - o.p;
        }
    }
}
