package one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나머지 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        long count = 0;
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        long[] S = new long[N+1];
        long[] remainCount = new long[M];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i=1; i<N+1; i++){
            S[i] = S[i-1] + Integer.parseInt(stringTokenizer.nextToken());
            int a = (int)S[i] % M;
            remainCount[a]++;
            if(a == 0){
                count++;
            }
        }

        for(int k=0; k<M; k++){
            if(remainCount[k]>1){
                count += (remainCount[k] * (remainCount[k]-1)) / 2;
            }
        }

        System.out.println(count);
    }
}
