package ten;

import java.io.*;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class p1890 {
    static int n;
    static int[][] maze;
    static long[][] dp;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        maze = new int[n][n];
        for (int i = 0; i <n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new long[n][n];
        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int now = maze[i][j];
                if(now == 0){
                    break;
                }
                if(j+now<n) dp[i][j+now] += dp[i][j];
                if(i+now<n) dp[i+now][j] += dp[i][j];
            }
        }


        System.out.println(dp[n-1][n-1]);
    }
}
