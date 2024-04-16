package four;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p11404 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 도시
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        // 버스
        int m = Integer.parseInt(st.nextToken());

        int[][] distance = new int[n + 1][n + 1];

        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=n; j++) {
                if(i==j){
                    distance[i][j] = 0;
                }else{
                    distance[i][j] = 10000001;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(distance[s][e] > c) distance[s][e] = c;
        }

        for (int k = 1; k <=n; k++) {
            for (int i = 1; i <=n; i++) {
                for (int j = 1; j <=n; j++) {
                    if(distance[i][j] > distance[i][k] + distance[k][j]){
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }

        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=n; j++) {
                if(distance[i][j] == 10000001){
                    sb.append("0 ");
                }else{
                    sb.append(distance[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        bw.write(String.valueOf(sb));

        bw.flush();
        bw.close();
    }
}
