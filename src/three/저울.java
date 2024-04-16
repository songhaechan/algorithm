package three;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

// 미친 문제 이걸 어떻게 생각햐냐 ?
public class 저울 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        // 1부터 데이터를 주지않으면 무조건 1이 답
        int sum = 1;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for(int i=0; i<arr.length; i++) {
            if(sum < arr[i])
                break;
            sum += arr[i];
        }

        bw.write(sum+"\n");
        bw.flush();
        bw.close();
    }
}
