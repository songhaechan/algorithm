package two;

import java.io.*;
import java.util.StringTokenizer;

public class 선택정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        String n = stringTokenizer.nextToken();
        int size = n.length();
        int[] array = new int[size];

        for (int i = 0; i <size ; i++) {
            array[i] = Integer.parseInt(n.substring(i,i+1));
        }

        for (int i = 0; i < size - 1; i++) {
            int max = array[i];
            int swapIndex = i;
            for (int j = i+1; j < size; j++) {
                if(array[j] > max){
                    max = array[j];
                    swapIndex = j;
                }
            }
            swap(array, i,swapIndex);
        }

        for (int i = 0; i < size; i++) {
            System.out.print(array[i]);
        }

    }
    private static void swap(int[] a,int first, int second){
        int tmp = a[first];
        a[first] = a[second];
        a[second] = tmp;
    }
}
