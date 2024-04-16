package bj219;


import java.io.*;
import java.util.*;

public class p1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(st.nextToken());
        long target = Integer.parseInt(st.nextToken());

        long[] lan = new long[K];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            lan[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(lan);

        //upper bound binary search
        long left = 1;
        long right = lan[K-1]+1;
        while(left < right){
            long mid = (right + left)/2;
            long now = 0;
            for (int i = 0; i < lan.length; i++) {
                now += lan[i]/mid;
            }
            if(now >= target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        sb.append(left-1);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
