package ele;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class p16948 {
    static int[] dr = {-2, -2, 0, 0, +2, +2};
    static int[] dc = {-1, +1, -2, +2, -1, +1};
    static int[][] field;
    static boolean[][] isVisited;
    static int r2, c2;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        field = new int[N][N];
        isVisited = new boolean[N][N];
        st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        boolean flag = bfs(new int[]{r1, c1});
        if(flag){
            System.out.println(field[r2][c2]);
        }else{
            System.out.println(-1);
        }
    }

    static boolean bfs(int[] start) {
        Queue<int[]> que = new LinkedList<>();
        que.add(start);
        isVisited[start[0]][start[1]] = true;
        boolean isGoal = false;
        while (!que.isEmpty()) {
            int[] now = que.poll();
            for (int i = 0; i < 6; i++) {
                int pr = now[0] + dr[i];
                int pc = now[1] + dc[i];
                if (pr < 0 || pc < 0 || pr > N-1 || pc>N-1 || isVisited[pr][pc]) continue;
                que.add(new int[]{pr,pc});
                field[pr][pc] = field[now[0]][now[1]] + 1;
                isVisited[pr][pc] = true;
                if(pr==r2 && pc==c2){
                    isGoal=true;
                    break;
                }
            }
        }
        return isGoal;
    }
}
