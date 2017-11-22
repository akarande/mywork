package leetcode;

public class ProductOfArrayButSelf {

	public void productButSelf(int arr[]) {
		int product = 1;
		int temp[] = new int[arr.length];
		for(int i = 0; i < arr.length; i++) {
			temp[i] = product;
			product = product * arr[i];
		}
		product = 1;
		for(int i = arr.length-1; i >= 0; i--) {
			temp[i] = product;
			product = product * arr[i];
		}
		
		for(int a : temp) System.out.print(a + "\t");
	}
	
	public static void main(String arg[]) {
		int arr[] = {0, 1, 3, 4, 2};
		ProductOfArrayButSelf pabs = new ProductOfArrayButSelf();
		pabs.productButSelf(arr);
	}
}
