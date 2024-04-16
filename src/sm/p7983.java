package sm;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p7983 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        PriorityQueue<Node> que = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            que.offer(new Node(d,t));
        }
        Node init = que.poll();
        int res = init.t - init.d;
        while(!que.isEmpty()){
            Node now = que.poll();
            if(res < now.t){
                res = res - now.d;
            }else{
                res = now.t - now.d;
            }
        }
        System.out.println(res);
    }
    static class Node implements Comparable<Node>{
        int d;
        int t;

        public Node(int d, int t) {
            this.d = d;
            this.t = t;
        }

        @Override
        public int compareTo(Node o) {
            return o.t - this.t;
        }
    }
}
