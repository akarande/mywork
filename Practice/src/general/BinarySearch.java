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
	
	
	public static void main(String arg[]) {
		BinarySearch bs = new BinarySearch();
		int arr[] = {12, 19, 25, 34, 46, 56, 64, 71, 87, 89, 91};
		int val = 91;
		System.out.println(bs.binarySearch(arr, 0, arr.length-1, val));
		System.out.println(bs.searchIterative(arr, val));
	}
}
