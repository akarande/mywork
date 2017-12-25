package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        return solve(nums);
    }
    
    List<List<Integer>> solve(int arr[]) {
        List<List<Integer>>ans = new ArrayList<>();
        for(int k = 0; k < arr.length-2; k++) {   //for each k find if nums[i] + nums[j] = -k
            if(k > 0 && arr[k] == arr[k-1]) continue;
            int left = k+1, right = arr.length-1, target = -arr[k];
            while(left < right) {
                if(arr[left] + arr[right] == target) {
                    ans.add(Arrays.asList(arr[k], arr[left], arr[right]));
                    while(left < right && arr[left] == arr[left+1]) left++;
                    while(left < right && arr[right] == arr[right-1]) right--;
                    left++;
                    right--;
                } else if(arr[left] + arr[right] > target) right--;
                else left++;
            }
        }
        return ans;
    }
    
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        int currSum = 0;
        for(int i = 0; i < nums.length-2; i++) {
            int left = i+1, right = nums.length-1;
            while(left < right) {
                currSum = nums[i] + nums[left] + nums[right];
                if(Math.abs(target - currSum) < Math.abs(target - ans)) {
                    ans = currSum;
                    if(ans == target) return ans;
                }
                if(currSum > target) right--;
                else left++;
            }
        }
        return ans;
    }
	
	public static void main(String arg[]) {
		ThreeSum ts = new ThreeSum();
		//int nums[] = {-1,0,1,2,-1,-4};
		//ts.threeSum(nums).stream().forEach(e -> System.out.print(e.toString() + " "));
		int nums[] = {1,1,1,0};
		int target = -100;
		System.out.println(ts.threeSumClosest(nums, target));
	}
}
