package nine;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p4485 {
    static int[] dx = new int[]{0,1,0,-1};
    static int[] dy = new int[]{1,0,-1,0};
    static int n;
    static int[][] blackRupee;
    static boolean[][] visited;
    static final int INF = 10000001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        n=1;
        int number = 1;
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if(n==0){
                break;
            }
            blackRupee = new int[n][n];
            visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    blackRupee[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int result = bfs(new Node(0,0,blackRupee[0][0]));
            System.out.println("Problem "+number+": "+result);
            number++;
        }
    }
    // 다익스트라
    static int bfs(Node node){
        PriorityQueue<Node> que = new PriorityQueue<>();
        int[][] distance = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i],INF);
        }
        distance[0][0] = blackRupee[0][0];
        que.offer(node);
        while(!que.isEmpty()){
            Node now = que.poll();
            if(now.x == n-1 && now.y == n-1){
                return now.blackRupee;
            }
            for (int i = 0; i < 4; i++) {
                int x = now.x + dx[i];
                int y = now.y + dy[i];
                int cost = now.blackRupee;
                if(x>=0 && y>=0 && x<n && y<n){
                    if(cost+blackRupee[y][x]<distance[y][x]){
                        distance[y][x] = cost+blackRupee[y][x];
                        que.offer(new Node(x,y,cost+blackRupee[y][x]));
                    }
                }
            }
        }
        return 0;
    }
    static class Node implements Comparable<Node>{
        int x;
        int y;
        int blackRupee;

        public Node(int x, int y, int blackRupee) {
            this.x = x;
            this.y = y;
            this.blackRupee = blackRupee;
        }

        @Override
        public int compareTo(Node o) {
            return this.blackRupee - o.blackRupee;
        }
    }
}
