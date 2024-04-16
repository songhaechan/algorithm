package nine;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class p1261 {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static boolean[][] visited;
    static int result = 0;
    static int n;
    static int m;
    static ArrayDeque<Node> que = new ArrayDeque<>();
    static int[][] maze;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // x축
         m = Integer.parseInt(st.nextToken());
        // y축
         n = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1][m+1];
        maze = new int[n+1][m+1];
        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 1; j <m+1 ; j++) {
                maze[i][j] = Integer.parseInt(line.substring(j-1,j));
            }
        }
        System.out.println(bfs(new Node(1,1,0)));
    }
    static int bfs(Node node){
        visited[node.y][node.x] = true;
        que.offer(node);
        while(!que.isEmpty()){
            Node now = que.poll();
            if(now.y == n && now.x==m){
                return now.cnt;
            }
            for (int k = 0; k < 4; k++) {
                int x = now.x + dx[k];
                int y = now.y + dy[k];
                int cnt = now.cnt;
                if(x>0 && y>0 && x<=m && y<=n){
                    if(maze[y][x] == 0 && !visited[y][x]){
                        que.offerFirst(new Node(x,y,cnt));
                        visited[y][x] = true;
                    }
                    if(maze[y][x] ==1 && !visited[y][x]){
                        que.offer(new Node(x,y,cnt+1));
                        visited[y][x] = true;
                    }
                }
            }
        }
        return 0;
    }
    static class Node implements Comparable<Node>{
        int x;
        int y;
        int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            return this.cnt - o.cnt;
        }
    }
}
