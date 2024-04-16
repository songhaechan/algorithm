package nine;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class p2178 {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static boolean[][] visited;
    static int[][] maze;
    static LinkedList<int[]> que = new LinkedList<>();
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 세로 y축
        n = Integer.parseInt(st.nextToken());
        // 가로 x축
        m = Integer.parseInt(st.nextToken());
        maze = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];
        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 1; j < m+1; j++) {
                maze[i][j] = Integer.parseInt(line.substring(j-1,j));
            }
        }
        bfs(1,1);

        System.out.println(maze[n][m]);
    }
    static void bfs(int i, int j){
        que.offer(new int[]{i,j});
        visited[i][j] = true;
        while(!que.isEmpty()){
            int[] now = que.poll();
            for (int k = 0; k < 4; k++) {
                int y = now[0] + dy[k];
                int x = now[1] + dx[k];
                if(x>0 && y>0 && x<=m && y<=n){
                    if(maze[y][x] != 0 && !visited[y][x]){
                        visited[y][x] = true;
                        maze[y][x] = maze[now[0]][now[1]] + 1;
                        que.offer(new int[]{y,x});
                    }
                }
            }
        }
    }
}
