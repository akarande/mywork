package leetcode;

import java.util.Arrays;

public class NextPermutation {

	public void nextPermutation(int[] nums) {
        int i = nums.length-2;
        while(i >= 0 && nums[i] >= nums[i+1]) i--;
        if(i >= 0) {
            int j = nums.length-1;
            while(nums[j] <= nums[i]) j--;
            swap(nums, i, j);
        }
        reverse(nums, i+1, nums.length-1);
    }
    
    void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
    
    void reverse(int[] nums, int x, int y) {
        while(x <= y) {
            swap(nums, x, y);
            x++;
            y--;
        }
    }
    
    public static void main(String arg[]) {
    	NextPermutation np = new NextPermutation();
    	int nums[] = {1, 3, 2};
    	np.nextPermutation(nums);
    	Arrays.stream(nums).forEach(e -> System.out.print(e + " "));
    }
}
