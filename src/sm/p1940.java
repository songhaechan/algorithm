package sm;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int start = 0;
        int end=N-1;
        int count=0;
        int sum = arr[end] + arr[start];
        while(start!=end){
            if(sum == M){
                count++;
                sum -= arr[end];
                end--;
                sum += arr[end];
            }else if(sum>M){
                sum -= arr[end];
                end--;
                sum += arr[end];
            }else{
                sum = sum - arr[start];
                start++;
                sum += arr[start];
            }

        }
        System.out.println(count);
    }
}
