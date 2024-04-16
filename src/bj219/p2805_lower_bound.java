package bj219;

import java.io.*;
import java.util.*;

public class p2805_lower_bound {
    // lower bound binary search + 보정 [별로 좋지 못한 방법]
    public static void main(String[] args) throws IOException{
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
        // lower bound logic
        while(left<right){
            long mid = (right + left)/2;
            remain = 0;
            for (int i = 0; i < N; i++) {
                if(trees[i]-mid > 0){
                    remain += trees[i] - mid;
                }
            }
            if(remain > target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        // lower bound 보정
        remain = 0;
        for (int i = 0; i < N; i++) {
            if(trees[i]-left > 0){
                remain += trees[i] - left;
            }
        }
        if(remain<target){
            left--;
        }
        sb.append(left);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}
