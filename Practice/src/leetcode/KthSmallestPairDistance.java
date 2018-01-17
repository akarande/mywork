package leetcode;

import java.util.Arrays;

public class KthSmallestPairDistance {

	public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int minDiff = nums[1] - nums[0];    //Get minimum distance
        for(int i = 1; i < n-1; i++) {
            minDiff = Math.min(minDiff, nums[i+1] - nums[i]);
        }
        int maxDiff = nums[n-1] - nums[0];  //Get max distance
        
        while(minDiff < maxDiff) {
            int mid = (minDiff + maxDiff)/2;
            if(count(nums, mid) < k) minDiff = mid + 1;
            else maxDiff = mid;
        }
        return minDiff;
    }
    
    //Method to calculate the pairs that have difference less than or equal to K
    int count(int arr[], int mid) {
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            int k = i;
            while(k < arr.length && arr[k] - arr[i] <= mid) k++;
            count += (k - i - 1);
        }
        return count;
    }
    
    public static void main(String arg[]) {
    	KthSmallestPairDistance kspd = new KthSmallestPairDistance();
    	int nums[] = {1,3,5,4,2};
    	int k = 2;
    	System.out.println(kspd.smallestDistancePair(nums, k));
    }
}
