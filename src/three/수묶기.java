package three;

import java.io.*;
import java.util.*;

public class 수묶기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        int result = 0;
        int zeroCnt = 0;

        // 양수 우선 순위 큐
        PriorityQueue<Integer> pqp = new PriorityQueue<>(Comparator.reverseOrder());
        // 음수 우선 순위 큐
        PriorityQueue<Integer> pqn = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            // 양수는 양수 큐
            if(arr[i] > 0){
                pqp.add(arr[i]);
            }
            // 음수는 음수 큐
            if(arr[i]<0){
                pqn.add(arr[i]);
            }
            // 0은 개수만
            if(arr[i] == 0){
                zeroCnt++;
            }
        }

        while(!pqp.isEmpty()){
            Integer elem1 = pqp.poll();
            Integer elem2 = pqp.poll();
            // 마지막 elem2가 null이면 elem1만 합
            if(elem2 == null){
                result += elem1;
                // elem1이 1이든 아니든 elem2가 1 + elem1
            }else if(elem2 == 1){
                result += 1 + elem1;
            }else{
                result += elem1 * elem2;
            }
        }

        while(!pqn.isEmpty()){
            Integer elem1 = pqn.poll();
            Integer elem2 = pqn.poll();
            // 0 이 있고 음수의 개수가 홀수면 0을 곱하고 종료
            if(elem2 == null && zeroCnt > 0){
                break;
                // 0이 없고 음수가 홀수개면 그냥 음수 합
            }else if(elem2 == null && zeroCnt ==0){
                result += elem1;
                break;
            }
            // 기본적으로 음수*음수 합
            result += elem1*elem2;
        }

        bw.write(result+"\n");


        bw.flush();
        bw.close();
    }
}
