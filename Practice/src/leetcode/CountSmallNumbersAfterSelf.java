package leetcode;

import java.util.ArrayList;
import java.util.List;

public class CountSmallNumbersAfterSelf {

	public List<Integer> countSmaller(int[] nums) {
        List<Integer>ans = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            ans.add(solve(i, nums, i+1, 0));
        }
        return ans;
    }
    
    int solve(int currPos, int [] nums, int pos, int count) {
        if(pos >= nums.length) return count;
        if(currPos < pos && nums[currPos] > nums[pos]) count++;
        return solve(currPos, nums, pos+1, count);
    }
    
    public static void main(String arg[]) {
    	CountSmallNumbersAfterSelf csnas = new CountSmallNumbersAfterSelf();
    	int nums[] = {5, 2, 6, 1};
    	System.out.println(csnas.countSmaller(nums).toString());
    }
}
