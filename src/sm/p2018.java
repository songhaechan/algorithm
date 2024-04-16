package sm;

import java.io.*;
import java.util.StringTokenizer;

public class p2018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int sum = 1;
        int count = 1;
        int start = 1;
        int end = 1;
        while(end != N){
            if(sum == N){
                count++;
                end++;
                sum += end;
            } else if (sum<N) {
                end++;
                sum += end;
            }
            else{
                sum -= start;
                start++;
            }
        }

        System.out.println(count);
    }
}
