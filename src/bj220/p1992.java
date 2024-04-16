package bj220;

import java.io.*;
import java.util.StringTokenizer;

public class p1992 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int[][] tree = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < n; j++) {
                tree[i][j] = Integer.parseInt(line.substring(j,j+1));
            }
        }

        bw.flush();
        bw.close();
    }
    static void recursive(){

    }
}
