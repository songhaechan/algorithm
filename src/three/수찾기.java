package three;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] nArr = new int[n];
        for (int i = 0; i < n; i++) {
            nArr[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int[] mArr = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            mArr[i] = Integer.parseInt(st.nextToken());
        }

        // 이진탐색을 위한 정렬
        Arrays.sort(nArr);

        // 이진 탐색
        for (int i = 0; i < m; i++) {
            int target = mArr[i];
            sb.append(binarySearch(nArr, target)).append("\n");
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
    private static int binarySearch(int[] arr, int target){
        int s = 0;
        int e = arr.length-1;
        int m = (s+e) / 2;
        int result = 0;
        while(s < e){
            if(target < arr[m]){
                e = m-1;
                m = m = (s+e) / 2;
            }
            if(arr[m] < target){
                s = m+1;
                m = m = (s+e) / 2;
            }
            if(arr[m] == target)
                break;
        }
        if(arr[m] == target){
            result = 1;
        }
        return result;
    }
}

