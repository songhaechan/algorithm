package five;

import java.io.*;
import java.util.StringTokenizer;

public class p11726 {
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());

        // top - down : recursive

        //dp table
        dp = new long[1001];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <n+1; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }

        sb.append(dp[n]);
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}
