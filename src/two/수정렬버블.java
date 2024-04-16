package two;

import java.io.*;
import java.util.StringTokenizer;

public class 수정렬버블 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            array[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n-1; j++) {
                if(array[j] > array[j+1]){
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
        for (int i = 0; i <n; i++) {
            bufferedWriter.write(array[i]+"\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
