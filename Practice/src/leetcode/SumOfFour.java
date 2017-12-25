package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfFour {
	public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>>result = new ArrayList<>();
        Arrays.sort(nums);
        solve(nums, 0, target, 0, new ArrayList<>(), result);
        return result;
    }
    
    void solve(int[] nums, int pos, int target, int currSum, List<Integer>currList, List<List<Integer>> result) {
        if(currList.size() > 4 || currList.size() == 4 && currSum != target) return;
        if(currList.size() == 4 && target == currSum && !result.contains(currList)) {
            result.add(new ArrayList<>(currList));
        }
        for(int i = pos; i < nums.length; i++) {
            if(nums[i] + (3 - currList.size()) * nums[nums.length-1] + currSum < target) continue;
            if(nums[i] * (4 - currList.size()) + currSum > target) return;
            currList.add(nums[i]);
            solve(nums, i+1, target, currSum+nums[i], currList, result);
            currList.remove(currList.size()-1);
        }
    }
	    
	    public static void main(String arg[]) {
	    	SumOfFour sof = new SumOfFour();
	    	int nums[] = {1, 0, -1, 0, -2, 2};
	    	int target = 0;
	    	List<List<Integer>>res = sof.fourSum(nums, target);
	    	for(List<Integer> ls :res) {
	    		ls.stream().forEach(e -> System.out.print(e + "\t"));
	    		System.out.println();
	    	}
	    }
}
