package two;

import java.io.*;
import java.util.StringTokenizer;

public class 버블소트2 {
    static int[] arr;
    static int[] tmp;
    static long result;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        arr = new int[n+1];
        tmp = new int[n+1];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i < n+1; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        result = 0;
        mergeSort(1,n);
        System.out.println(result);
    }
    private static void mergeSort(int start, int end){
        // 부분배열의 크기가 1이면 그만
        if(end - start < 1)
            return;
        // m은 부분배열의 경계선 m+1은 다음 부분배열의 시작 인덱스
        int m = start + (end - start) / 2;
        mergeSort(start,m);
        mergeSort(m+1,end);
        for (int i = start; i <= end; i++) {
            tmp[i] = arr[i];
        }
        int k = start;
        // 좌측 부분배열의 시작 인덱스
        int index1 = start;
        // 우측 부분배열의 시작 인덱스
        int index2 = m+1;
        // 좌,우측 각 배열의 끝까지 반복
        while(index1 <= m && index2 <= end){
            if(tmp[index1] > tmp[index2]){
                arr[k] = tmp[index2];
                // 인덱스의 차이가 swap 의 횟수 -> 누적해서 총 swap 횟수
                // 이 조건문만 유일하게 swap 이 일어남
                result += index2 - k;
                k++;
                index2++;
            }else{
                arr[k] = tmp[index1];
                k++;
                index1++;
            }
        }
        // 이미 정렬된 좌측 부분 배열을 배치
        while (index1 <= m){
            arr[k] = tmp[index1];
            k++;
            index1++;
        }
        // 이미 정렬된 우측 부분 배열을 배치
        while(index2 <= end){
            arr[k] = tmp[index2];
            k++;
            index2++;
        }
    }
}
