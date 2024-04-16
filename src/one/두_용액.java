package one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두_용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int[] S = new int[N];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for(int i=0; i<N; i++){
            S[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(S);

        int left = 0;
        int right = N-1;
        int[] ans = new int[2];
        int sum;
        int sumAbs;
        int max = Integer.MAX_VALUE;



        while(left<right){
            sum = S[left] + S[right];
            sumAbs = Math.abs(sum);
            if(sumAbs < max){
                max = sumAbs;
                ans[0] = S[left];
                ans[1] = S[right];
            }
            if(sum > 0){
                right--;
            }else{
                left++;
            }
        }

        System.out.print(ans[0]+" "+ans[1]);


    }
}
