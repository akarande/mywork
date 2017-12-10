package leetcode;

public class SubarraySum {

	public int subarraySum(int[] nums, int k) {
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
        	int sumSoFar = nums[i];
        	if(sumSoFar == k) ans++;
        	for(int j = i+1; j < nums.length; j++) {
	        	sumSoFar += nums[j];
	            if(sumSoFar == k) {
	                ans++;
	            }
        	}
        }
        return ans;
    }
	
	public static void main(String arg[]) {
		SubarraySum ss = new SubarraySum();
		int nums[] = {1,1,1};
		int k = 2;
		System.out.println(ss.subarraySum(nums, k));
	}
}
