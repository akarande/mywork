package leetcode;

import java.util.HashMap;
import java.util.Map;

public class DegreeOfArray {

	public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer>freq = new HashMap<>();
        int maxFreq = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if(!freq.containsKey(nums[i])) freq.put(nums[i], 1);
            else freq.put(nums[i], freq.get(nums[i]) + 1);
            maxFreq = Math.max(maxFreq, freq.get(nums[i]));
        }
        int ans = nums.length + 1;
        for(Integer keys : freq.keySet()) {
            int f = freq.get(keys);
            if(f == maxFreq) {
                int i = 0;
                int begin = -1, end = -1;
                while(f > 0 && i < nums.length) {
                    if(nums[i] == keys) {
                        f--;
                        if(begin == -1) begin = i;
                        end = i;
                    }
                    i++;
                }
                if(f == 0) ans = Math.min(ans, end-begin+1);
            }
        }
        return ans;
    }
	
	public static void main(String arg[]) {
		int nums[] = {1, 2, 2, 3, 1};
		DegreeOfArray doa = new DegreeOfArray();
		System.out.print(doa.findShortestSubArray(nums));
	}
}
