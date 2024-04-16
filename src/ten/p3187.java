package ten;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p3187 {
    static int R,C;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int ansOfK = 0;
    static int ansOfV = 0;
    static boolean[][] isVisited;
    static String[][] maze;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        maze = new String[R][C];
        isVisited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < C; j++) {
                maze[i][j] = line.substring(j,j+1);
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(isVisited[i][j]) continue;
                if(maze[i][j].equals(".") || maze[i][j].equals("k") || maze[i][j].equals("v")){
                    bfs(i,j);
                }
            }
        }
        sb.append(ansOfK).append(" ").append(ansOfV);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    static void bfs(int x, int y){
        Queue<Point> que = new LinkedList<>();
        que.offer(new Point(x,y));
        isVisited[x][y] = true;
        int k=0;
        int v=0;
        if(maze[x][y].equals("v")) v++;
        if(maze[x][y].equals("k")) k++;
        while(!que.isEmpty()){
            Point now = que.poll();
            for (int i = 0; i < 4; i++) {
                int curX = now.x + dx[i];
                int curY = now.y + dy[i];
                if(curX<0 || curY<0 || curX>=R || curY>=C) continue;
                if(isVisited[curX][curY] || maze[curX][curY].equals("#")) continue;
                que.offer(new Point(curX,curY));
                isVisited[curX][curY] = true;
                if(maze[curX][curY].equals("v")) v++;
                if(maze[curX][curY].equals("k")) k++;
            }
        }
        if(k>v){
            ansOfK += k;
        }else{
            ansOfV += v;
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
