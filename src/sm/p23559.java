package sm;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p23559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        PriorityQueue<Node> que = new PriorityQueue<>();
        int res = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 1000원 메뉴부터 모두 식사
            res += b;
            X -= 1000;
            que.add(new Node(a,b));
        }
        for (int i = 0; i < N; i++) {
            Node now = que.poll();
            if(X+1000 >= 5000 && now.diff>0){
                res -= now.menu1000;
                X += 1000;
                res += now.menu5000;
                X -= 5000;
            }
        }

        System.out.println(res);
    }
    static class Node implements Comparable<Node>{
        int menu5000;
        int menu1000;
        int diff;

        public Node(int menu5000, int menu1000) {
            this.menu5000 = menu5000;
            this.menu1000 = menu1000;
            this.diff = menu5000 - menu1000;
        }

        @Override
        public int compareTo(Node o) {
            return o.diff - this.diff;
        }
    }
}
