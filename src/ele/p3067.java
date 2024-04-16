package ele;

import java.io.*;
import java.util.StringTokenizer;

public class p3067 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());
        int[] dp;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] coins = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                coins[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            int target = Integer.parseInt(st.nextToken());
            dp = new int[target+1];
            dp[0] = 1;
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <=target; k++) {
                    if(k-coins[j-1] >=0){
                        dp[k] += dp[k-coins[j-1]];
                    }
                }
            }
            System.out.println(dp[target]);
        }
        bw.flush();
        bw.close();
    }
}
