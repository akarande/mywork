package leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer>map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int findNum = Math.abs(nums[i]-target);
            if(map.containsKey(findNum)) return new int[] {i, map.get(findNum).intValue()};
            else map.put(nums[i], i);
        }
        return new int[0];
    }
	
	public static void main(String arg[]) {
		TwoSum ts = new TwoSum();
		int nums[] = {3,2,4};
		int target = 6;
		for(int x : ts.twoSum(nums, target)) {
			System.out.print(x + "\t");
		}
		System.out.println();
	}
}
