package five;

import java.io.*;
import java.util.List;
import java.util.StringTokenizer;

public class p2193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        // 자리 수
        int n = Integer.parseInt(st.nextToken());
        long[] dp = new long[n+1];
        dp[1] = 1;
        long[] numberOfZero = new long[n+1];
        long[] numberOfOne = new long[n+1];
        numberOfZero[1] = 0;
        numberOfOne[1] = 1;

        for (int i = 2; i <= n; i++) {
            numberOfZero[i] = numberOfZero[i-1] + numberOfOne[i-1];
            numberOfOne[i] = numberOfZero[i-1];
            dp[i] = numberOfZero[i] + numberOfOne[i];
        }
        System.out.println(dp[n]);
    }
}
