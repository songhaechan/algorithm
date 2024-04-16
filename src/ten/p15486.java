package ten;

import java.io.*;
import java.util.StringTokenizer;

public class p15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int[] dp = new int[n+2];
        int[] T = new int[n+2];
        int[] P = new int[n+2];

        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        int max = -1;

        for (int i = 1; i <= n + 1; i++) {
            if(max<dp[i]){
                max = dp[i];
            }
            int next = i+T[i];
            if(next<n+2){
                dp[next] = Math.max(dp[next],max+P[i]);
            }
        }
        bw.write(sb.append(dp[n+1]).toString());
        bw.flush();
        bw.close();
    }
}
