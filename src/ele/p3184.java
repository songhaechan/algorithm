package ele;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p3184 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static String[][] field;
    static boolean[][] isVisited;
    static int R;
    static int C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        field = new String[R][C];
        isVisited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < C; j++) {
                field[i][j] = line.substring(j, j + 1);
            }
        }
        int sheep = 0;
        int wolves = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!isVisited[i][j] && !field[i][j].equals("#")) {
                    int[] res = bfs(new int[]{i, j});
                    sheep += res[0];
                    wolves += res[1];
                }
            }
        }
        System.out.println(sheep+" "+wolves);
    }

    static int[] bfs(int[] point) {
        Queue<int[]> que = new LinkedList<>();
        isVisited[point[0]][point[1]] = true;
        que.add(point);
        int tmpSheep = 0;
        int tmpWolves = 0;
        if (field[point[0]][point[1]].equals("o")) tmpSheep++;
        if (field[point[0]][point[1]].equals("v")) tmpWolves++;
        while (!que.isEmpty()) {
            int[] now = que.poll();
            for (int i = 0; i < 4; i++) {
                int px = now[0] + dx[i];
                int py = now[1] + dy[i];
                if (px < 0 || py < 0 || px >= R || py >= C || field[px][py].equals("#") || isVisited[px][py]) continue;
                if (field[px][py].equals("o")) tmpSheep++;
                if (field[px][py].equals("v")) tmpWolves++;
                isVisited[px][py] = true;
                que.add(new int[]{px,py});
            }
        }
        if(tmpSheep>tmpWolves){
            return new int[]{tmpSheep,0};
        }else{
            return new int[]{0,tmpWolves};
        }
    }
}
