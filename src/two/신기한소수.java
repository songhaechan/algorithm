package two;

import java.io.*;
import java.util.StringTokenizer;

public class 신기한소수 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());

        int[] firstDigit = {2,3,5,7};

        for(int i : firstDigit){
            DFS(i,1, n);
        }

        bufferedWriter.flush();
        bufferedWriter.close();
    }
    private static void DFS(int number, int digit, int targetDigit){
        if(digit == targetDigit){
            System.out.println(number);
            return;
        }
        int[] a = {1,3,5,7,9};
        for(int i : a){
            int target = number*10 + i;
            if(isPrime(target)){
                DFS(target,digit+1, targetDigit);
            }
        }
    }
    private static boolean isPrime(int number){
        for (int i = 2; i <= number - 1; i++) {
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }
}
