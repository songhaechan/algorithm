package bj219;

import java.util.*;
import java.io.*;

public class p10815 {
    // binary search의 가장 일반적 형태
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] list = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            int s = 0;
            int e = N-1;
            boolean flag = false;
            while(s<=e){
                int mid = (s+e)/2;
                if(target == list[mid]){
                    System.out.print(1+" ");
                    flag = true;
                    break;
                } else if(list[mid] > target){
                    e = mid-1;
                }else{
                    s = mid + 1;
                }
            }
            if(!flag){
                System.out.print(0+" ");
            }
        }
    }
}
