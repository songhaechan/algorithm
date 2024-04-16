package seven;

import java.io.*;
import java.util.StringTokenizer;

public class p2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int maxK = 15;
        int maxN = 15;

        int[][] apartment = new int[maxK][maxN];

        // 0층 초기화 (누적합)
        for (int i = 1; i <maxN ; i++) {
            apartment[0][i] = i + apartment[0][i-1];
        }

        for (int i = 1; i <maxK ; i++) {
            for (int j = 1; j <maxN ; j++) {
                apartment[i][j] = apartment[i-1][j] + apartment[i][j-1];
            }
        }


        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i <T ; i++) {
            st = new StringTokenizer(br.readLine());
            // 층 0층 ~ 14층
            int k = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            // 호 1호 ~ 14호
            int n = Integer.parseInt(st.nextToken());
            System.out.println(apartment[k][n] - apartment[k][n-1]);

        }
        bw.flush();
        bw.close();
    }
}
