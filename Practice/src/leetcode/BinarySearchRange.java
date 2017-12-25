package leetcode;

public class BinarySearchRange {

	public int[] searchRange(int[] nums, int target) {
        int a0 = binarySearch1(nums, target, 0, nums.length-1);
        int a1 = binarySearch2(nums, target, 0, nums.length-1);
        return new int[] { a0, a1 };
    }
    
    int binarySearch1(int[] nums, int target, int low, int high) {
        int ans = -1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(nums[mid] >= target) high = mid-1;
            else low = mid+1;
            if(nums[mid] == target) ans = mid;
        }
        return ans;
    }
    
    int binarySearch2(int[] nums, int target, int low, int high) {
        int ans = -1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(nums[mid] <= target) low = mid+1;
            else high = mid-1;
            if(nums[mid] == target) ans = mid;
        }
        return ans;
    }
    
    public static void main(String arg[]) {
    	BinarySearchRange bsr = new BinarySearchRange();
    	int[] nums = {5,7,7,8,8,10};
    	int target = 8;
    	int[] res = bsr.searchRange(nums, target);
    	System.out.println(res[0] + ", " + res[1]);
    }
}
