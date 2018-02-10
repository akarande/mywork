package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {

	public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer>currList = new ArrayList<>();
        if(nums == null || nums.length == 0) return currList;
        Arrays.sort(nums);
        int i, j;
        int dp[] = new int[nums.length];
        dp[0] = 1;
        //calculate the largest subset length
        for(i = 1; i < nums.length; i++) {
            for(j = i-1; j >= 0; j--) {
                if(nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        //calculate the largest index
        int maxIndex = 0;
        for(i = 1; i < nums.length; i++) {
            maxIndex = dp[maxIndex] < dp[i] ? i : maxIndex;
        }
        
        int currMax = nums[maxIndex];
        int dpMax = dp[maxIndex];
        for(i = maxIndex; i >= 0; i--) {
            if(currMax % nums[i] == 0 && dpMax == dp[i]) {
                currList.add(0, nums[i]);
                currMax = nums[i];
                dpMax--;
            }
        }
        return currList;
    }
	
	public static void main(String arg[]) {
		LargestDivisibleSubset lds = new LargestDivisibleSubset();
		int nums[] = {2,3,4,8,9,27};
		System.out.println(lds.largestDivisibleSubset(nums).toString());
	}
}
