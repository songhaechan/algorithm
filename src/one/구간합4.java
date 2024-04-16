package one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class 구간합4 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        long[] sum = new long[n+1];
        System.out.println(sum[1]);

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i=1;i<=n;i++){
            sum[i] = sum[i-1] + Integer.parseInt(stringTokenizer.nextToken());
        }

        for(int j=0; j<m; j++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(sum[b]-sum[a-1]);
        }
    }
}
