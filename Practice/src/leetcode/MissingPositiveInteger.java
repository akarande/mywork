package leetcode;

public class MissingPositiveInteger {

	public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; ++i) {
            int curr = nums[i];
            while(curr <= n && curr > 0 && nums[curr-1] != curr) {
                swap(nums, curr-1, i);
                curr = nums[i];
            }
        }
        
        for(int i = 0; i < n; ++i) {
            if(nums[i] != i+1) return i+1;
        }
        return n+1;
    }
    
    void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    
    public static void main(String arg[]) {
    	int[] arr = {3,4,-1,1};
    	MissingPositiveInteger mpi = new MissingPositiveInteger();
    	System.out.println(mpi.firstMissingPositive(arr));
    }
}
