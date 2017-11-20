package leetcode;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicates {
	    public int removeDuplicates(int[] nums) {
	        List<Integer>ans = new ArrayList<>();
	        int previous = -1;
	        int currCount = 0;
	        for(int i = 0; i < nums.length; i++) {
	            if(nums[i] == previous && currCount < 2) {
	                ans.add(nums[i]);
	                currCount++;
	            }
	            if(nums[i] != previous) {
	                ans.add(nums[i]);
	                previous = nums[i];
	                currCount = 1;
	            }
	        }
	        System.out.println(ans);
	        return ans.size();
	    }
	    
	    public static void main(String args[]) {
	    	int[] nums = /*{1,1,1,2};*/  {1, 1, 1, 2, 2, 3};
	    	System.out.println("OUTPUT " + new RemoveDuplicates().removeDuplicates(nums));
	    }
}
