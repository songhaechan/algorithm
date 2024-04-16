package one;

import java.io.IOException;
import java.util.Scanner;

public class 수들의_합 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        int start = 1;
        int end = 1;
        int sum = 1;
        int count = 1;
        while(end != N){
            if(sum == N){
                count++;
                end++;
                sum = sum + end;
            }else if(sum > N){
                sum = sum - start;
                start++;
            }else{
                end++;
                sum = sum + end;
            }
        }

        System.out.println(count);


    }
}
