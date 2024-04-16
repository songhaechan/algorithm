package nine;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p25644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n][2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(st.nextToken());

            if(i==0){
                dp[i][0] = 0;
                dp[i][1] = cur;
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0],cur - dp[i-1][1]);
            dp[i][1] = Math.min(dp[i-1][1],cur);
        }
        System.out.println(dp[n-1][0]);
    }
}
