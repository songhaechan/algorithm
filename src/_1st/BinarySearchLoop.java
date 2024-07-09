package _1st;

import java.util.Arrays;

public class BinarySearchLoop {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        Arrays.sort(nums);
        int result = -1;
        while(l<=r){
            int mid = (l+r)/2;
            if(target == nums[mid]){
                result = mid;
                break;
            }
            if(target<nums[mid]){
                r = mid-1;
            }
            if(nums[mid]<target){
                l = mid+1;
            }
        }
        return result;
    }
}
