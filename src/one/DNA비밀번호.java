package one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DNA비밀번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int S = Integer.parseInt(stringTokenizer.nextToken());
        int P = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        char[] DNA = stringTokenizer.nextToken().toCharArray();

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] ACGT = new int[4];
        for(int i=0; i<4; i++){
            ACGT[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int start = 0;
        int end = P-1;

        int[] currentACGT = new int[P];
        int[] countACGT = new int[4];

        // 초기 currentACGT 의 개수
        for(int i=0; i<P; i++){
            if(DNA[i] == 'A') countACGT[0]++;
            if(DNA[i] == 'C') countACGT[1]++;
            if(DNA[i] == 'G') countACGT[2]++;
            if(DNA[i] == 'T') countACGT[3]++;
        }

        int count = 0;

        for(int i=0; i<4; i++){
            if(countACGT[i] >= ACGT[i]);
            else {
                count--;
                break;
            }
        }
        count++;
        while(end != S-1){
            end++;
            if(DNA[end] == 'A') countACGT[0]++;
            if(DNA[end] == 'C') countACGT[1]++;
            if(DNA[end] == 'G') countACGT[2]++;
            if(DNA[end] == 'T') countACGT[3]++;

            if(DNA[start] == 'A') countACGT[0]--;
            if(DNA[start] == 'C') countACGT[1]--;
            if(DNA[start] == 'G') countACGT[2]--;
            if(DNA[start] == 'T') countACGT[3]--;
            start++;
            count++;
            for(int i=0; i<4; i++){
                if(countACGT[i] >= ACGT[i]);
                else{
                    count--;
                    break;
                }
            }
        }

        System.out.println(count);


    }
}
