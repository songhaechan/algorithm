package ele;

import java.io.*;
import java.util.StringTokenizer;


public class p1034 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] line = new String[N];
        int[] count = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < M; j++) {
                if (s.charAt(j) == '0') {
                    count[i]++;
                }
            }
            line[i] = s;
        }

        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());

        int max = 0;

        for (int i = 0; i < N; i++) {
            if (count[i] <= K && (K - count[i]) % 2 == 0) {
                int res = 1;
                for (int j = 0; j < N; j++) {
                    if (i == j) continue;
                    if (line[i].equals(line[j]))
                        res++;
                }
                max = Math.max(max, res);
            }
        }
        System.out.println(max);
    }
}
