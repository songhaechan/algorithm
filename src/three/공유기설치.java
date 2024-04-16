package three;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 공유기설치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] x = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(x);


        // n개 설치 구간길이 최소
        int min = 1;

        // 2개 설치 구간길이 최대 / +1은 upper bound 때문
        int max = x[n-1] - x[0] +1;

        while(min < max) {
            int mid = (min + max) /2;
            // 첫 집은 설치 왜???????
            int cnt = 1;

            int pre = x[0];
            for (int i = 1; i <x.length ; i++) {
                if(x[i] - pre >= mid){
                    cnt++;
                    pre=x[i];
                }
            }

            if(cnt < c){
                max = mid;
            }else{
                min = mid + 1;
            }
        }

        bw.write((min-1)+"\n");
        bw.flush();
        bw.close();
    }
}
