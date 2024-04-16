package ele;

import java.io.*;
import java.util.StringTokenizer;

public class p2666 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] doors = new int[n+1];

        int door1 = Integer.parseInt(st.nextToken());
        doors[door1] = 1;
        int door2 = Integer.parseInt(st.nextToken());
        doors[door2] = 1;

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int door = Integer.parseInt(st.nextToken());
            doors[door] = 0;
        }


    }
}
