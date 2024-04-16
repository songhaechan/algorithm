package ten;

import java.io.*;
import java.util.StringTokenizer;

public class p14921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = n-1;
        int ans = arr[end]+arr[start];

        while(start<end){
            if(Math.abs(arr[end]+arr[start])<Math.abs(ans)){
                ans = arr[end]+arr[start];
            }
            if(arr[end] + arr[start]>0){
                end--;
            }else{
                start++;
            }
        }

        System.out.println(ans);
    }
}
