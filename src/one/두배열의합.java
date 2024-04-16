package one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 두배열의합 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int T = Integer.parseInt(stringTokenizer.nextToken());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int[] A = new int[N+1];
        int aSize = N*(N-1)/2 + N;
        int[] CA = new int[aSize];
        int k =0;
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i=1; i<N+1; i++){
            A[i] = A[i-1] + Integer.parseInt(stringTokenizer.nextToken());
        }

        for(int i=0; i<N;i++){
            for(int j=i+1; j<N+1;j++){
                CA[k] = A[j] - A[i];
                k++;
            }
        }
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int[] B = new int[M+1];
        int bSize = M*(M-1)/2 + M;
        int[] CB = new int[bSize];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i=1; i<M+1; i++){
            B[i] = B[i-1] + Integer.parseInt(stringTokenizer.nextToken());
        }

        int h =0;
        for(int i=0; i<M;i++){
            for(int j=i+1; j<M+1;j++){
                CB[h] = B[j] - B[i];
                h++;
            }
        }

        Arrays.sort(CB);
        Arrays.sort(CA);
        int count = 0;
        int pointA = 0;
        int pointB = bSize-1;
        while(pointA < aSize && pointB > -1){
            long a = CA[pointA];
            long b = CB[pointB];
            long sum = a+b;
            if(sum == T){
                int aCnt =0;
                int bCnt =0;
                while(pointA<aSize && CA[pointA] == a){
                    pointA++;
                    aCnt++;
                }
                while(pointB>-1 && CB[pointB] == b){
                    pointB--;
                    bCnt++;
                }
                count += bCnt*aCnt;
            }
            if(sum > T){
                pointB--;
            }
            if(sum < T){
                pointA++;
            }
        }
        System.out.println(count);
    }
}
