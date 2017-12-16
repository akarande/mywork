package leetcode;

public class QuickSort {

	void partition(int arr[], int low, int high) {
		if(low < high) {
			int mid = (low + high) / 2;
			partition(arr, low, mid);
			partition(arr, mid+1, high);
			quickSort(arr, low, high);
		}
	}
	
	void quickSort(int[] arr, int left, int right) {
		int i = left;
		int j = right;
		int mid = (left + right) / 2;
		int pivot = arr[mid];
		while(i <= j) {
			while(arr[i] < pivot) i++;
			while(arr[j] > pivot) j--;
			if(i <= j)  {
				swap(arr, i, j);
				i++;
				j--;
			}
		}
		if(j > left) quickSort(arr, left, j);
		if(i < right) quickSort(arr, i, right);
	}
	
	void swap(int arr[], int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
	
	void printArray(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
	}
	
	public static void main(String arg[]) {
		QuickSort qs = new QuickSort();
		int arr[] = {87, 56, 21, 53, 13, 31, 78, 2};//{81, 73, 24, 62, 13, 8, 40, 29, 84};
		qs.partition(arr, 0, arr.length-1);
		qs.printArray(arr);
	}
}
