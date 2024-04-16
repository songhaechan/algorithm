package five;

import java.io.*;
import java.util.StringTokenizer;

public class p14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int[] t = new int[n+1];
        int[] p = new int[n+1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n+2];

        for (int i = n; i >0 ; i--) {
            if(i + t[i] > n+1){
                dp[i] = dp[i+1];
            }else{
                dp[i] = Math.max(dp[i+1],p[i]+dp[i+t[i]]);
            }
        }
        System.out.println(dp[1]);
    }
}
