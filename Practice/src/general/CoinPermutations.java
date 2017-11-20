package general;

import java.util.ArrayList;
import java.util.List;

/**
 * Sum up coins for a target values
 * @author akarande
 * 10 => {1, 2, 5, 10}
 */

public class CoinPermutations {
	
	int arr[] = {1, 2, 5, 10};
	List<List<Integer>>nums = new ArrayList<>();

	//Complexity 2^k
	int solve(int n, int k) {
		if(n == 0) {
			return 1;
		} else if(n < 0 || k >= arr.length) {
			return 0;
		} else {
			return solve(n, k+1) + solve(n-arr[k], k);
		}
	}
	
	//Complexity m*n m => total coins, n => the target value
	int solve2(int n) {
		int len = arr.length;
		int table[] = new int[n+1];
		for(int i = 0; i < table.length; i++) {
			table[i] = 0;
		}
		//Base condition
		table[0] = 1;
		for(int i = 0; i < len; i++) {
			for(int j = arr[i]; j <= n; j++) {
				table[j] += table[j - arr[i]];
			}
		}
		return table[n];
	}
	
	public static void main(String arg[]) {
		CoinPermutations cp = new CoinPermutations();
		int val = 5;
		//System.out.println(cp.solve(val, 0));
		System.out.println(cp.solve2(val));
	}
}
