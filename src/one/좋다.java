package one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 좋다 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        long[] numList = new long[N];
        for(int i=0; i<N; i++){
            numList[i] = Long.parseLong(stringTokenizer.nextToken());
        }

        Arrays.sort(numList);

        int count = 0;
        long sum = 0;
        for(int j=0; j<N; j++){
            int start = 0;
            int end = N-1;
            long target = numList[j];
            while(start != end){
                // 다른 수여야하기 때문에 인덱스가 같으면 넘긴다.
                if(start == j){
                    start++;
                    continue;
                }else if(end == j){
                    end--;
                    continue;
                }
                sum = numList[start]+numList[end];
                if(target > sum){
                    start++;
                } else if (target < sum) {
                    end--;
                }else{
                    count++;
                    break;
                }
            }
        }

        System.out.println(count);


    }
}
