package bj220;

import java.io.*;
import java.util.StringTokenizer;

public class p4779 {
    static String[] ans;
    static int n;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String str;
        while ((str = br.readLine()) != null) {
            if(str.equals("")) break;
            n = Integer.parseInt(str);
            sb = new StringBuilder();
            int length = (int) Math.pow(3, n);
            for (int i = 0; i < length; i++) {
                sb.append("-");
            }
            recursive(0, length);
            sb.append("\n");
            bw.write(sb.toString());
        }
        bw.flush();
        bw.close();
    }

    static void recursive(int start, int size) {
        if (size == 1) {
            return;
        }
        int newSize = size / 3;
        for (int i = start + newSize; i < start + newSize * 2; i++) {
            sb.setCharAt(i, ' ');
        }
        recursive(start, newSize);
        recursive(start + 2 * newSize, newSize);
    }
}
