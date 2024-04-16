package bj220;

import java.io.*;
import java.util.StringTokenizer;

public class p2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        long V = Integer.parseInt(st.nextToken());

        long lastLength = V-A;

        long oneDay = A-B;

        long ans;
        if(V == A){
            ans = 0;
        }else{
            if(lastLength<A){
                ans = 1;
            }else{
                ans = (long)Math.ceil((double) lastLength /oneDay);
            }
        }

        System.out.println(ans + 1);
    }
}
