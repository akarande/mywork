package general;

public class BinarySearch {

	
	public int binarySearch(int arr[], int low, int high, int val) {
		if(low > high) return -1;
		int mid = (low + high) / 2;
		if(arr[mid] == val) return mid;
		if(arr[mid] > val) return binarySearch(arr, low, mid-1, val);
		else return binarySearch(arr, mid+1, high, val);
	}
	
	public int searchIterative(int arr[], int val) {
		int low = 0, high = arr.length - 1;
		while(low <= high) {
			int mid = (low + high) / 2;
			if(arr[mid] == val) return mid;
			if(arr[mid] > val) high = mid - 1;
			else low = mid + 1;
		}
		return -1;
	}
	
	/**
	 * Modified Binary Search, searches for an element or provides the 
	 * position at which the element can be placed.
	 * @param arr
	 * @param key
	 * @return
	 * https://stackoverflow.com/questions/6553970/find-the-first-element-in-a-sorted-array-that-is-greater-than-the-target
	 */
	public int modifiedBinarySearch(int[] arr, int key) {
		int low = 0, high = arr.length-1, mid = -1;
		boolean found = false;
		while(low < high) {
			mid = (low + high) / 2;
			if(arr[mid] == key) {
				found = true;
				break;
			} else if(arr[mid] > key) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		if(found) {
			return mid;
		} else if(low >= arr.length) {
			return -1;
		} else {
			return low;
		}
	}
	
	public static void main(String arg[]) {
		BinarySearch bs = new BinarySearch();
		int arr[] = {12, 19, 25, 34, 46, 56, 64, 71, 87, 89, 91};
		int val = 25;
		/*System.out.println(bs.binarySearch(arr, 0, arr.length-1, val));
		System.out.println(bs.searchIterative(arr, val));*/
		System.out.println(bs.modifiedBinarySearch(arr, val));
	}
}
