package two;

import java.io.*;
import java.util.StringTokenizer;

public class ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());

        int[] array = new int[n];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        for (int i = 1; i < n; i++) {
            int target = array[i];
            int targetIndex = i;
            for (int j = i-1; j >=0 && array[j]>target; j--) {
                    array[j+1] = array[j];
                    targetIndex = j;
            }
            array[targetIndex] = target;
        }
        int[] sumArray = new int[n];

        sumArray[0] = array[0];
        for (int i = 1; i < n; i++) {
            sumArray[i] = array[i] + sumArray[i-1];
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += sumArray[i];
        }
        System.out.println(sum);
    }
}
