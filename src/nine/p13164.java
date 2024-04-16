package nine;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p13164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] diff = new int[n-1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n - 1; i++) {
            diff[i] = arr[i+1] - arr[i];
        }

        Arrays.sort(diff);

        int result = 0;

        //
        for (int i = 0; i <n-k; i++) {
            result += diff[i];
        }

        System.out.println(result);
    }
}
