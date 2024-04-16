package two;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class 오큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());

        int[] nArray = new int[N];
        int[] answer = new int[N];

        Stack<Integer> stack = new Stack<>();

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i <N ; i++) {
            nArray[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        stack.push(0);
        for (int i = 1; i <N ; i++) {
            while(!stack.isEmpty() && nArray[stack.peek()] < nArray[i]){
                answer[stack.pop()] = nArray[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            answer[stack.pop()] = -1;
        }

        for (int i = 0; i <N ; i++) {
            bufferedWriter.write(answer[i] + " ");
        }
        bufferedWriter.write("\n");
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
