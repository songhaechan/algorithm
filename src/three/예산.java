package three;

import java.io.*;
import java.util.StringTokenizer;

public class 예산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[] money = new int[n];
        int max = 0;
        int min = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            money[i] = Integer.parseInt(st.nextToken());
            if (max < money[i]) max = money[i];
        }

        st = new StringTokenizer(br.readLine());
        int budget = Integer.parseInt(st.nextToken());


        while (min <= max) {
            int mid = (min + max) / 2;
            int totalSum = 0;
            for (int i = 0; i < n; i++) {
                if (money[i] < mid) totalSum += money[i];
                else totalSum += mid;
            }
            if (budget >= totalSum) {
                min = mid + 1;
            }
            if (budget < totalSum) {
                max = mid - 1;
            }
        }
        System.out.println(max);

    }
}
