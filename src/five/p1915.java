package five;

import java.io.*;
import java.util.StringTokenizer;

public class p1915 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[][] arr = new long[n+1][m+1];
        for (int i = 1; i <n+1 ; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 1; j <m+1 ; j++) {
                arr[i][j] = Long.parseLong(String.valueOf(line.charAt(j-1)));
            }
        }
        long max = 0;
        for (int i = 1; i <n+1 ; i++) {
            for (int j = 1; j <m+1 ; j++) {
                if(arr[i][j] == 1){
                    arr[i][j] = Math.min(arr[i-1][j-1],Math.min(arr[i-1][j],arr[i][j-1]))+arr[i][j];
                }
                if(max < arr[i][j]){
                    max = arr[i][j];
                }
            }
        }
        System.out.println(max*max);
    }
}
