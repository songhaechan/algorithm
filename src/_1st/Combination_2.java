package _1st;

import java.util.ArrayList;
import java.util.List;

public class Combination_2 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList();
        backtrack(1,result,n,k,new ArrayList());
        return result;
    }
    public void backtrack(int start,List<List<Integer>> result,int n,int k,List<Integer> tmp){
        if(tmp.size() == k){
            result.add(new ArrayList(tmp));
            return;
        }

        for(int i=start;i<=n;i++){
            tmp.add(i);
            backtrack(i+1,result,n,k,tmp);
            tmp.remove(tmp.size()-1);
        }
    }
}
