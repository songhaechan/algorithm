package three;

import java.io.*;
import java.util.StringTokenizer;

public class 소수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i <n+1; i++) {
            for (int j = i+i; j <n+1; j+=i) {
                arr[j] = 1;
            }
        }

        for (int i = m; i < n+1; i++) {
            if(arr[i] == 0){
                sb.append(i).append('\n');
            }
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}
