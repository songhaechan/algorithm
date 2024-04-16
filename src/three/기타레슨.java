package three;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 기타레슨 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        int min = 0;
        for (int i = 0; i < n; i++) {
            max += arr[i];
            if(min < arr[i]) min = arr[i];
        }

        // Binary Search
        while (min <= max) {
            int mid = (min + max) / 2;
            int sum = 0;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (sum + arr[i] > mid) {
                    cnt++;
                    sum = 0;
                }
                sum += arr[i];
            }
            if (sum != 0) cnt++;
            if (cnt > m) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        bw.write(min + "\n");
        bw.flush();
        bw.close();
    }
}
