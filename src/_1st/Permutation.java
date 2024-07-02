package _1st;

import java.util.ArrayList;
import java.util.List;

class Permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        backtrack(result,nums,new ArrayList());
        return result;
    };
    public void backtrack(List<List<Integer>> result, int[] nums, List<Integer> tmp){

        if(tmp.size() == nums.length){
            result.add(new ArrayList(tmp));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(!tmp.contains(nums[i])){
                tmp.add(nums[i]);
                backtrack(result,nums,tmp);
                tmp.remove(tmp.size() -1);
            }
        }
    }

}
