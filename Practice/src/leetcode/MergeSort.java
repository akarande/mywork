package leetcode;

public class MergeSort {
	public void partition(int arr[], int low, int high) {
		if(low < high) {
			int mid = (low + high) / 2;
			partition(arr, low, mid);
			partition(arr, mid+1, high);
			merge(arr, low, mid, high);
		}
	}
	
	/**
	 * Here we create a temp array and populate it in a sorted order,
	 * once the range of low to high is stored in sorted order, we copy it back to original array.
	 * @param arr
	 * @param low
	 * @param mid
	 * @param high
	 */
	public void merge(int arr[], int low, int mid, int high) {
		int i = low;
		int j = mid+1;
		int k = low;
		int temp[] = new int[arr.length];
		while(i <= mid && j <= high) {
			temp[k++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
		}
		while(i <= mid) {
			temp[k++] = arr[i++];
		}
		while(j <= high) {
			temp[k++] = arr[j++];
		}
		
		for(i = low; i <= high; i++) {
			arr[i] = temp[i];
		}
	}
	
	/**
	 * Here we copy the range as is, from low to high into a temp array.
	 * Once the range is copied, we copy it back to original array's index from low to high.
	 * While the other parts of the original array are still un-sorted only the range of low to high
	 * is sorted in each iteration. 
	 * @param arr
	 * @param low
	 * @param mid
	 * @param high
	 */
	public void merge2(int arr[], int low, int mid, int high) {
		//Copy the current low to high into a temp array;
		int[] temp = new int[arr.length];
		for(int i = low; i <= high; i++) {
			temp[i] = arr[i];
		}
		
		int i = low;
		int j = mid+1;
		int k = low;
		//Compare and put it back to original array;
		while(i <= mid && j <= high) {
			arr[k++] = temp[i] < temp[j] ? temp[i++] : temp[j++];
		}
		while(i <= mid) {
			arr[k++] = temp[i++];
		}
	}
	
	void printArray(int[] arr) {
		for(int a : arr) {
			System.out.print(a + "\t");
		}
		System.out.println();
	}
	
	public static void main(String arg[]) {
		int arr[] = {44, 59, 21, 17, 88, 65, 34, 91, 14, 26};
		MergeSort ms = new MergeSort();
		ms.partition(arr, 0, arr.length-1);
		ms.printArray(arr);
		System.out.println();
	}
}
