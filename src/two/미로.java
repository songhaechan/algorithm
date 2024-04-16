package two;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 미로 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        //BFS를 위한 큐
        Deque<int[]> que = new LinkedList<>();

        int[] directionN = {0,1,0,-1};
        int[] directionM = {1,0,-1,0};

        // 가로 세로 초기화
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        // 방문 여부 초기화
        boolean[][] visited = new boolean[n+1][m+1];
        for (int i = 0; i <m+1 ; i++) {
            visited[0][i] = true;
        }
        for (int i = 0; i <n+1 ; i++) {
            visited[i][0] = true;
        }

        // 미로 초기화
        int[][] maze = new int[n+1][m+1];

        // 미로 파싱
        for (int i = 1; i <n+1; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String line = stringTokenizer.nextToken();
            for (int j = 1; j <m+1; j++) {
                maze[i][j] = Integer.parseInt(line.substring(j-1,j));
            }
        }

        // 1,1 부터 시작
        que.add(new int[]{1,1});
        visited[1][1] = true;

        while(!que.isEmpty()){
            int[] removed = que.remove();
            for (int i = 0; i <4; i++) {
                int x = removed[0] + directionM[i];
                int y = removed[1] + directionN[i];
                // 좌표 유효성 검사 (0은 못지나간다, 방문한 곳은 갈 수 없다)
                if(x <= n && y <= m){
                    if(!visited[x][y] && maze[x][y] != 0){
                        visited[x][y] = true;
                        maze[x][y] = maze[removed[0]][removed[1]] + 1;
                        que.add(new int[]{x,y});
                    }
                }
            }
        }
        System.out.println(maze[n][m]);
//        for (int i = 1; i <n+1 ; i++) {
//            for (int j = 1; j <m+1 ; j++) {
//                System.out.print(maze[i][j]);
//            }
//            System.out.println();
//        }
    }
}

