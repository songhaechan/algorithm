package one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 주몽 {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        int[] list = new int[N];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i=0; i<N; i++){
            list[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(list);

//        int start = list[0];
//        int end = list[0];
        int count = 0;
        int start = 0;
        int end = N-1;
        int sum = list[0]+list[N-1];
        while(start != end){
            if(sum == M){
                count++;
                sum = sum - list[end];
                end--;
                sum += list[end];
            }else if(sum < M){
                sum = sum - list[start];
                start++;
                sum = sum + list[start];
            }else{
                sum = sum - list[end];
                end--;
                sum += list[end];
            }
        }
        System.out.println(count);

    }
}
