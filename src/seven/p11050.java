package seven;

import java.io.*;
import java.util.StringTokenizer;

public class p11050 {
    static int mod = 10007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long combination[][] = new long[n+1][n+1];

        for (int i = 0; i <n+1 ; i++) {
            for (int j = 0; j <=i ; j++) {
                if(i==j||j==0){
                    combination[i][j] = 1;
                }else{
                    combination[i][j] = (combination[i-1][j-1] + combination[i-1][j])%mod;
                }
            }
        }

        System.out.println(combination[n][k]);
    }

}
