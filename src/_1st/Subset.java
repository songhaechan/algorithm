package _1st;
import java.util.ArrayList;
import java.util.List;

public class Subset {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        result.add(new ArrayList());
        for(int i=1; i<=nums.length; i++){
            backtrack(i,0,result,new ArrayList(),nums);
        }
        return result;
    }
    public void backtrack(int size, int start, List<List<Integer>> result, List<Integer> tmp, int[] nums){

        if(tmp.size() == size){
            result.add(new ArrayList(tmp));
            return;
        }
        for(int j=start; j<nums.length; j++){
            tmp.add(nums[j]);
            backtrack(size,j+1,result,tmp,nums);
            tmp.remove(tmp.size() -1);
        }

    };
}