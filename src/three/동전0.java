package three;

import java.io.*;
import java.util.StringTokenizer;

public class 동전0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;

        for (int i = n-1; i >=0; i--) {
            if(k - arr[i] < 0)
                continue;
            if(k - arr[i] == 0){
                count += k/arr[i];
                break;
            }
            if(k - arr[i] > 0){
                count += k/arr[i];
                k = k % arr[i];
            }
            if(k == 0){
                break;
            }
        }

        bw.write(count + "\n");

        bw.flush();
        bw.close();
    }
}
