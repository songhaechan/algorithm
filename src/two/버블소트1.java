package two;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 버블소트1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        data[] array = new data[n];

        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            array[i] = new data(Integer.parseInt(stringTokenizer.nextToken()),i);
        }
        Arrays.sort(array,(o1,o2)-> o1.value - o2.value);

        int maxIndexDiff = 0;
        for (int i = 0; i < n; i++) {
            // 정렬 전의 인덱스와 정렬 후의 인덱스 차이는 스왑한 횟수를 말하고
            // 스왑한 횟수의 최대값을 찾으면 그 최대값 이상으론 스왑이 일어나지 않았다는 걸 뜻한다.
            if(array[i].index - i > maxIndexDiff){
                maxIndexDiff = array[i].index - i;
            }
        }

        bufferedWriter.write(maxIndexDiff + 1+"\n");

        bufferedWriter.flush();
        bufferedWriter.close();
    }
    static class data{
        int value;
        int index;

        public data(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
