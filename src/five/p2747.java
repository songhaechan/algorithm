package five;

import java.io.*;
import java.util.StringTokenizer;

public class p2747 {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());

        dp = new int[n+1];

        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }

        dp[0] = 0;
        dp[1] = 1;

        fibo(n);

        sb.append(dp[n]);
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
    static int fibo(int n){
        if(dp[n] != -1){
            return dp[n];
        }

        return dp[n] = fibo(n-2) + fibo(n-1);
    }
}
