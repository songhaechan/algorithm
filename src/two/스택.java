package two;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class 스택 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter 를 사용하면 버퍼가 가득 찰 때 비동기적으로 flush 한다??????
        StringBuilder stringBuilder = new StringBuilder();
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(stringTokenizer.nextToken());

        int[] targetArray = new int[n];
        for (int i = 0; i <n; i++) {
            targetArray[i] = Integer.parseInt(bufferedReader.readLine());
        }

        // 일단 스택에 타겟수열의 첫 번째 인덱스의 크기만큼 push

        int pushElem = 1;
        for (int i = 0; i < targetArray[0]; i++) {
            stack.push(pushElem++);
            stringBuilder.append("+\n");
        }
        int targetIndex = 0;


        Integer preElem = stack.pop();
        stringBuilder.append("-\n");
        targetIndex++;

        int maxElem = preElem;

        // 주어진 수열의 마지막 인덱스까지가면 끝
        while(targetIndex != n){
            // 직전 요소보다 1작으면 Pop
            if(preElem - 1 == targetArray[targetIndex]){
                preElem = stack.pop();
                // 꺼낸 요소가 최대값보다 크면 업데이트
                // 최대값을 기준으로 push 할 요소가 결정
                if(maxElem < preElem){
                    maxElem = preElem;
                }
                stringBuilder.append("-\n");
                targetIndex++;
            }else{
                for (int i = 0; i <targetArray[targetIndex] - maxElem  ; i++) {
                    stack.push(pushElem++);
                    stringBuilder.append("+\n");
                }
                // 빼려는 요소가 stack 의 top에 있는지 검사 , 없으면 NO
                if(!stack.peek().equals(targetArray[targetIndex])){
                    break;
                }
                preElem = stack.pop();
                if(maxElem < preElem){
                    maxElem = preElem;
                }
                stringBuilder.append("-\n");
                targetIndex++;
            }
        }
        if(targetIndex == n){
            System.out.println(stringBuilder);
        }else{
            System.out.print("NO");
        }
    }
}
