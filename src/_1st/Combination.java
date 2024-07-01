package _1st;

import java.util.ArrayList;
import java.util.List;

public class Combination {
    static List<List<Integer>> result = new ArrayList<>();
    static List<Integer> tmp = new ArrayList<>();
    static int k = 2;

    public static void main(String[] args) {
        // 1~11까지 11개의 수 중에서 3개를 선택하는 모든 경우의 수
        // Recursion
        List<Integer> list = java.util.List.of(1, 2, 3, 4, 5, 6);

        backtrack(0,list,new ArrayList<>());

        System.out.println("result = " + result);

    }

    public static void backtrack(int start,List<Integer> target, List<Integer> tmp) {
        if (tmp.size() == k){
            result.add(new ArrayList<>(tmp));
            return;
        }
        for(int i=start; i<target.size();i++){
            tmp.add(i);
            backtrack(i+1,target,tmp);
            tmp.remove(tmp.size()-1);
        }
    }
}
