package five;

import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class p1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int[] dp = new int[n+1];
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            // 1을 빼는 연산
            dp[i] = dp[i-1]+1;
            if(i%2==0){
                // 2로 나누는 경우와 1을 빼는 경우 중 더 작은 경우를 dp에 넣는다.
                // dp[i/2] + 1 에서 + 1은 나누는 연산 횟수 추가임
                dp[i] = Math.min(dp[i],dp[i/2]+1);
            }
            if(i%3==0){
                dp[i] = Math.min(dp[i],dp[i/3]+1);
            }
        }

        System.out.println(dp[n]);
        bw.flush();
        bw.close();
    }
}
