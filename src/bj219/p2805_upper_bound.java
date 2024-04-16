package bj219;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p2805_upper_bound {
    // upper bound binary search
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] trees = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(trees);
        long left = 0;
        long right = trees[N-1]+1;
        long remain = 0;
        while(left<right){
            long mid = (right + left)/2;
            remain = 0;
            for (int i = 0; i < N; i++) {
                if(trees[i]-mid > 0){
                    remain += trees[i] - mid;
                }
            }
            if(remain < target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        sb.append(left-1);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
