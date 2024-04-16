package ten;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p14940 {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int n;
    static int m;
    static int[][] distance;
    static int[][] maze;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] goal = new int[2];
        maze = new int[n][m];
        distance = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int point = Integer.parseInt(st.nextToken());
                maze[i][j] = point;
                if(point ==2 ){
                    goal= new int[]{i,j};
                }
            }
        }
        bfs(goal[0],goal[1]);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                if (!visited[i][j] && maze[i][j] == 1)
                    sb.append(-1 + " ");
                else
                    sb.append(distance[i][j]).append(" ");
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    static void bfs(int x, int y){
        Queue<Point> que = new LinkedList<>();
        que.offer(new Point(x,y));
        visited[x][y] = true;
        while(!que.isEmpty()){
            Point now = que.poll();
            for (int i = 0; i < 4; i++) {
                int curX = now.x + dx[i];
                int curY = now.y + dy[i];

                if(curX<0 || curY<0 || curX>=n || curY>=m) continue;
                if(maze[curX][curY] == 0) continue;
                if(visited[curX][curY]) continue;

                que.add(new Point(curX,curY));
                distance[curX][curY] = distance[now.x][now.y] + 1;
                visited[curX][curY] = true;
            }
        }
    }
    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
