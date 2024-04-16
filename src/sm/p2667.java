package sm;

import java.io.*;
import java.util.*;

public class p2667 {
    static int N;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[][] maze;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        maze = new int[N][N];
        visited = new boolean[N][N];
        // 단지 수 저장
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < N; j++) {
                maze[i][j] = Integer.parseInt(line.substring(j,j+1));
            }
        }
        int complex = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(maze[i][j] == 1){
                    result.add(bfs(new int[]{i,j}));
                    complex++;
                }
            }
        }
        Collections.sort(result);
        sb.append(complex).append("\n");
        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    static int bfs(int[] house){
        Queue<int []> que = new LinkedList<>();
        que.add(house);
        int cnt = 1;
        visited[house[0]][house[1]] = true;
        while(!que.isEmpty()){
            int[] now = que.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx<N && nx>=0 && ny<N && ny>=0 && !visited[nx][ny] && maze[nx][ny]!=0){
                    que.add(new int[]{nx,ny});
                    cnt++;
                    maze[nx][ny] = 0;
                    visited[nx][ny] = true;
                }
            }
        }
        return cnt;
    }
}
