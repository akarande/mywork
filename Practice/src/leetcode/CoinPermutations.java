package leetcode;

import java.util.Arrays;

public class CoinPermutations {

	int coins[] = {1, 2, 3, 5, 10};
	
	//Recursive Solution Complexity 2^k
	int solve(int n, int k) {
		if(n == 0) return 1;
		if(n < 0 || k >= coins.length) return 0;
		return solve(n-coins[k], k) + solve(n, k+1);
	}
	
	//Table method Complexity O(m*n)
	int solve(int n) {
		int memo[] = new int[coins.length + 1];
		Arrays.fill(memo, 0);
		memo[0] = 1;
		for(int i = 0; i < coins.length; i++) {
			for(int j = coins[i]; j <= n; j++) {
				memo[j] += memo[j - coins[i]];
			}
		}
		return memo[n];
	}
	
	public static void main(String arg[]) {
		CoinPermutations cp = new CoinPermutations();
		System.out.println(cp.solve(5, 0));
		System.out.println(cp.solve(5));
	}
}
