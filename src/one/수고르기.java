package one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수고르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        long M = Long.parseLong(stringTokenizer.nextToken());

        long[] sequence = new long[N];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            sequence[i] = Long.parseLong(stringTokenizer.nextToken());
        }

        Arrays.sort(sequence);

        int start = 0;
        int end = 0;
        long result = Integer.MAX_VALUE;

        while(end < N){
            if(sequence[end]-sequence[start] == M){
                result=M;
                break;
            }
            if(sequence[end] - sequence[start] < M){
                end++;
                continue;
            }
            result = Math.min(result,sequence[end]-sequence[start]);
            start++;
        }

        System.out.println(result);
    }
}
