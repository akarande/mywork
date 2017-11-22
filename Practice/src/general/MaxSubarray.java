package general;

public class MaxSubarray {

	int solve(int arr[]) {
		int maxSoFar = 0;
		int maxEndingHere = 0;
		for(int i = 0; i < arr.length; i++) {
			maxEndingHere += arr[i];
			if(maxEndingHere < 0) {
				maxEndingHere = 0;
			}
			if(maxSoFar < maxEndingHere) {
				maxSoFar = maxEndingHere;
			}
		}
		return maxSoFar;
	}
	
	/**
	 * Uses Kadane's method
	 */
	int solve2(int arr[]) {
		int maxSoFar = arr[0];
		int maxEndingHere = arr[0];
		
		for(int i = 1; i < arr.length; i++) {
			maxEndingHere = Math.max(arr[i], maxEndingHere+arr[i]);
			maxSoFar = Math.max(maxSoFar, maxEndingHere);
		}
		return maxSoFar;
	}
	
	public static void main(String arg[]) {
		MaxSubarray msb = new MaxSubarray();
		int arr[] = {-2, 1, -3, 4, -1, 2, 1};
		System.out.println(msb.solve(arr));
	}
}
