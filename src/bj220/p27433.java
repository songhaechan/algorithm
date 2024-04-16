package bj220;

import java.io.*;
import java.util.StringTokenizer;

public class p27433 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        long n = Integer.parseInt(st.nextToken());

        if(n==0){
            System.out.println(1);
        }else{
            System.out.println(recursive(n));
        }
    }
    static long recursive(long n){
        if(n==1){
            return 1;
        }else{
            return n*recursive(n-1);
        }
    }
}
