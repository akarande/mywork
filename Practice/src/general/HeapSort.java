package general;

//Resource: https://www.unf.edu/~wkloster/3540/heap.java
public class HeapSort {
	
	int arr[] = {56, 37, 17, 90, 26, 49, 72, 14, 83, 65, 21};
	
	void buildHeap(int arr[]) {
		int n = arr.length;
		for(int i = n/2-1; i >= 0; i--) {
			heapify(arr, n, i);
		}
		
		for(int i = n-1; i >= 0; i--) {
			int t = arr[i];
			arr[i] = arr[0];
			arr[0] = t;
			heapify(arr, i, 0);
		}
	}
	
	void heapify(int arr[], int n, int i) {
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		int max = i;
		if(left < n && arr[left] > arr[max]) max = left;
		if(right < n && arr[right] > arr[max]) max = right;
		if(max != i) {
			swap(arr, max, i);
			heapify(arr, n, max);
		}
	}
	
	void swap(int arr[], int x, int y) {
		int t = arr[x];
		arr[x] = arr[y];
		arr[y] = t;
	}
	
	void printArray(int arr[]) {
		for(int a : arr) {
			System.out.print(a + " ");
		}
	}
	
	public static void main(String arg[]) {
		HeapSort hs = new HeapSort();
		hs.buildHeap(hs.arr);
		hs.printArray(hs.arr);
	}

}
