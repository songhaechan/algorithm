package two;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 카드2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        Queue<Integer> que = new LinkedList<>();

        for (int i = 1; i <N+1 ; i++) {
            que.add(i);
        }

        while(que.size() != 1){
            que.remove();
            Integer removedElem = que.remove();
            que.add(removedElem);
        }

        System.out.println(que.remove());

        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
