package five;

import java.io.*;
import java.util.StringTokenizer;

public class p10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long[][] dp = new long[n+1][11];
        //dp 테이블 초기화
        for (int i = 1; i <10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i < n+1; i++) {
            dp[i][0] = dp[i-1][1];
            dp[i][9] = dp[i-1][8];
            for (int j = 1; j < 9; j++) {
                // 왜 여기서도 나눠야하지? 2배씩 증가하니까 2^99
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])%1000000000;
            }
        }
        long sum = 0;
        for (int i = 0; i <10 ; i++) {
            sum = (sum+dp[n][i])%1000000000;
        }
        System.out.println(sum);

    }
}
