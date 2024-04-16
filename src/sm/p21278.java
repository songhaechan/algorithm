package sm;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p21278 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] floyd = new int[N+1][N+1];

        for (int i = 0; i <= N; i++) {
            Arrays.fill(floyd[i],10000001);
        }

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                if(i==j){
                    floyd[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            floyd[start][end] = 2; floyd[end][start] = 2;
        }
//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= N; j++) {
//                System.out.print(floyd[i][j] + " ");
//            }
//            System.out.println();
//        }
        // 플로이드 워셜 N^3
        // 경유지
        for (int i = 1; i <= N; i++) {
            // 출발지
            for (int j = 1; j <= N; j++) {
                // 도착지
                for (int k = 1; k <= N; k++) {
                    if(j==k || i==j || i==k){
                        continue;
                    }
                    floyd[j][k] = Math.min(floyd[j][k],floyd[j][i]+floyd[i][k]);
                }
            }
        }
        int[] res = new int[N+1];
        int sum = Integer.MAX_VALUE;
        int tmp = 0;
        int firstChicken = 101;
        int secondChicken = 101;

        for (int i = 1; i <= N-1; i++) {
            for (int j = i+1; j <=N ; j++) {
                for (int k = 1; k <=N ; k++) {
                    int min = Math.min(floyd[i][k],floyd[j][k]);
                    tmp += min;
                }
                if(sum > tmp){
                    sum = tmp;
                    firstChicken = i;
                    secondChicken = j;
                }
                tmp = 0;
            }
        }
        sb.append(firstChicken+ " ").append(secondChicken + " ").append(sum);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
