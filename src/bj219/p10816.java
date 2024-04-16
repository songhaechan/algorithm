package bj219;

import java.io.*;
import java.util.*;

public class p10816 {
    // lower bound binary search
    static int[] list;
    static int[] given;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        list = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        given = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            given[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<M; i++){
            int ans = upperBound(given[i])-lowerBound(given[i]);
            sb.append(ans).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    static int lowerBound(int target){
        int left = 0;
        int right = N;
        while(left<right){
            int mid = (left+right)/2;
            if(list[mid]>=target){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
    static int upperBound(int target){
        int left = 0;
        int right = N;
        while(left<right){
            int mid = (left+right)/2;
            if(list[mid]<=target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }

}
