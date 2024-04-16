package five;

import java.io.*;
import java.util.StringTokenizer;

public class p13398 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] left = new int[n];
        left[0] = arr[0];
        int[] right = new int[n];
        right[n-1] = arr[n-1];
        int result = left[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(arr[i],arr[i]+left[i-1]);
            result = Math.max(left[i],result);
        }

        for (int i = n-2; i >=0 ; i--) {
            right[i] = Math.max(arr[i],arr[i]+right[i+1]);
        }

        for (int i = 1; i < n-1; i++) {
            int tmp = left[i-1] + right[i+1];
            result = Math.max(result,tmp);
        }

        System.out.println(result);

        bw.flush();
        bw.close();
    }
}
