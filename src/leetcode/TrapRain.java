package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class TrapRain {
    public int trap(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] answer = height.clone();
        int pre = 0;
        for(int current=0; current<height.length; current++){
            int h = height[current];
            while(!stack.isEmpty()&&h>=height[stack.peek()]){
                pre = stack.pop();
                System.out.print(pre);
            }

            if(!stack.isEmpty()){
                pre = stack.peek();
                for(int j=pre+1; j<current; j++){
                    answer[j] = h;
                }
            }else{
                for(int j=pre+1; j<current; j++){
                    answer[j] = height[pre];
                }
            }
            stack.push(current);
        }
        int result = 0;
        for(int i=0; i<height.length; i++){
            System.out.print(answer[i]);
            result+= answer[i] - height[i];
        }

        return result;
    }
}
