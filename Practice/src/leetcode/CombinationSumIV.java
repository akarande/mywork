package leetcode;

import java.util.Arrays;

public class CombinationSumIV {

	int arr[];
    public int combinationSum4(int[] nums, int target) {
        this.arr = new int[target+1];
        Arrays.fill(this.arr, -1);
        arr[0] = 1;
        return recursive(nums, target);
    }
    
    int recursive(int[] nums, int target) {
        if(this.arr[target] != -1) return arr[target];
        int count = 0;
        for(int x : nums) {
            if(target >= x) {
                count += recursive(nums, target-x);
            }
        }
        this.arr[target] = count;
        return count;
    }
    
    public static void main(String arg[]) {
    	CombinationSumIV csv = new CombinationSumIV();
    	int nums[] = {1,2,3};
    	int target = 4;
    	System.out.println(csv.combinationSum4(nums, target));
    }
}
