package one;

import java.util.Scanner;

public class 소수의_연속합 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();

        // 에라토스테네스의 체

        int[] numbers = new int[N+1];

        numbers[0] = 0;
        numbers[1] = 0;
        for(int i=2; i<N+1; i++){
            numbers[i] = i;
        }

        for(int i=2; i<N; i++){
            if(numbers[i] == 0) continue;
            for(int j = 2*i; j<N+1; j+=i){
                numbers[j] = 0;
            }
        }

        // 소수를 새로운 배열에 저장

        int primeCount = 0;

        for(int i=0; i<N+1; i++){
            if(numbers[i] != 0){
                primeCount++;
            }
        }

        int[] prime = new int[primeCount];

        int k=0;
        for(int i=0; i<N+1; i++){
            if(numbers[i] != 0){
                prime[k] = numbers[i];
                k++;
            }
        }

        // 소수의 누적합

        int[] primeAcuml = new int[primeCount+1];

        for(int i=1; i<primeCount+1; i++){
            primeAcuml[i] = primeAcuml[i-1] + prime[i-1];
        }

        int sum = 0;
        int count = 0;
        int start = 0;
        int end = 1;

        while(end != primeCount+1){
            sum = primeAcuml[end]-primeAcuml[start];
            if(sum == N){
                count++;
                end++;
            }
            if(sum > N){
                start++;
            }
            if(sum < N){
                end++;
            }
        }
        System.out.println(count);
    }
}
