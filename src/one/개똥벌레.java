package one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 개똥벌레 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int H = Integer.parseInt(stringTokenizer.nextToken());

        int[] down = new int[N/2];
        int[] up = new int[N/2];

        for(int i=0; i<N/2; i++){
            down[i] = Integer.parseInt(bufferedReader.readLine());
            up[i] = Integer.parseInt(bufferedReader.readLine());
        }

        Arrays.sort(down);
        Arrays.sort(up);

        int result = 0;
        int min = N;

        for(int i=0; i<H; i++){
            int count = binarySearch(0,N/2,i+1,down)+binarySearch(0,N/2, H-i,up);
            if(min == count){
                result++;
                continue;
            }
            if(min >count){
                min = count;
                result = 1;
            }
        }
        System.out.println(min+" "+result);
    }
    private static int binarySearch(int left, int right, int h, int[] arr){
        while(left<right){
            int mid = (left+right)/2;
            if(arr[mid] >= h){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return arr.length - right;
    }
}
