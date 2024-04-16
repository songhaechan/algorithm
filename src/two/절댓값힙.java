package two;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 절댓값힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());

        PriorityQueue<Integer> que = new PriorityQueue<>((o1, o2) -> {
            int absO1 = Math.abs(o1);
            int absO2 = Math.abs(o2);
            if(absO1 == absO2){
                // o1이 1 o2가 -1 이면 양수를 리턴해서 자리바꾸기
                if(o1 > o2){
                    return 1;
                }else{
                    return -1;
                }
            }else{
                return absO1 - absO2;
            }
        });


        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int input = Integer.parseInt(stringTokenizer.nextToken());
            if (input == 0){
                if(que.isEmpty()){
                    bufferedWriter.write("0\n");
                }else{
                    bufferedWriter.write(que.remove()+"\n");
                }
            }else{
                que.add(input);
            }
        }


        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
