package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DailyTemperature {
    public static void main(String[] args) {

    }

    // 복잡도가 너무 높음 2000ms
    public int[] myDailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        int[] answer = new int[temperatures.length];
        Arrays.fill(answer,0);

        int i=1;
        while(!stack.isEmpty() && i<temperatures.length){
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                int idx = stack.pop();
                System.out.println("pop :"+idx);
                answer[idx] = i-idx;
            }
            while(stack.isEmpty() || temperatures[stack.peek()] >= temperatures[i]){
                System.out.println("push :"+i);
                stack.push(i++);
                if(i == temperatures.length){
                    break;
                }
            }
        }
        return answer;
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] answer = new int[temperatures.length];


        for(int i=0; i<temperatures.length; i++){
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                int idx = stack.pop();
                System.out.println(idx);
                answer[idx] = i-idx;
            }
            stack.push(i);
        }

        return answer;
    }


}
