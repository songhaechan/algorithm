package five;

import java.io.*;
import java.util.StringTokenizer;

public class p1328 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        long[][][] arr = new long[n+1][n+1][n+1];
        arr[1][1][1] = 1;
        for (int i = 2; i < n+1; i++) {
            for (int j = 1; j <l+1 ; j++) {
                for (int k = 1; k <r+1 ; k++) {
                    arr[i][j][k] = (arr[i-1][j][k]*(i-2) + arr[i-1][j-1][k] + arr[i-1][j][k-1])%1000000007;
                }
            }
        }

        bw.write(String.valueOf(sb.append(arr[n][l][r])));
        bw.flush();
        bw.close();
    }
}
