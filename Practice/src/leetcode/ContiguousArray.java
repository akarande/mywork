package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
	public int findMaxLength(int[] nums) {
        if(nums == null || nums.length < 2) return 0;
        int zeros = 0, ones = 0, max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                zeros++;
            } else {
                ones++;
            }
            if(map.containsKey(zeros-ones)) {
                max = Math.max(max, i - map.get(zeros-ones));
            }
            else {
                map.put(zeros-ones, i);
            }
        }
        return max;
    }
	
	public static void main(String arg[]) {
		ContiguousArray ca = new ContiguousArray();
		int nums[] = {0,1,1,1,0,0,0,1,0,0,1,0,1};
		System.out.println(ca.findMaxLength(nums));
	}

}
