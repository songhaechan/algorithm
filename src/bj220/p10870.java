package bj220;

import java.io.*;
import java.util.StringTokenizer;

public class p10870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        System.out.println(recursive(n));
    }
    static long recursive(long n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return recursive(n-1) + recursive(n-2);
    }
}
