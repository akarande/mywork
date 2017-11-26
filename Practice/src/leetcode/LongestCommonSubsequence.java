package leetcode;

import java.util.Arrays;

public class LongestCommonSubsequence {

	int memo[][];
	
	public int longestCommonSubsequence(String s1, String s2) {
		int m = s1.length(), n = s2.length();
		int dp[][] = new int[m+1][n+1];
		for(int i = 0; i < m+1; i++) {
			Arrays.fill(dp[i], 0);
		}
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n ;j++) {
				char c1 = s1.charAt(i-1);
				char c2 = s2.charAt(j-1);
				if(c1 == c2) {
					dp[i][j] = 1 + dp[i-1][j-1];
				} else {
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
				}
			}
		}
		return dp[m][n];
	}
	
	//Using recursion
	public int longestCommonSubsequence2(String s1, String s2) {
		if(s1.length() == 0 || s2.length() == 0) return 0;
		if(s1.charAt(0) == s2.charAt(0)) {
			return 1 + longestCommonSubsequence(s1.substring(1), s2.substring(1));
		} else {
			int l1 = longestCommonSubsequence(s1, s2.substring(1));
			int l2 = longestCommonSubsequence(s1.substring(1), s2);
			return Math.max(l1, l2);
		}
	}
	
	//Recursion + memoization
	public int longestCommonSubsequence(String s1, String s2, int p1, int p2) {
		if(p1 == s1.length() || p2 == s2.length()) return 0;
		if(memo[p1][p2] != -1) return memo[p1][p2];
		else if(s1.charAt(p1) == s2.charAt(p2)) {
			return memo[p1][p2] = 1 + longestCommonSubsequence(s1, s2, p1+1, p2+1);
		} else {
			int lcs1 = longestCommonSubsequence(s1, s2, p1, p2+1);
			int lcs2 = longestCommonSubsequence(s1, s2, p1+1, p2);
			return memo[p1][p2] = Math.max(lcs1, lcs2);
		}
	}
	
	public static void main(String arg[]) {
		String s1 = "abcbdcb";
		String s2 = "acbdbc";
		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		System.out.println(lcs.longestCommonSubsequence(s1, s2));
		System.out.println(lcs.longestCommonSubsequence2(s1, s2));
		lcs.memo = new int[s1.length()][s2.length()];
		for(int i = 0; i < lcs.memo.length; i++) {
			Arrays.fill(lcs.memo[i], -1);
		}
		System.out.println(lcs.longestCommonSubsequence(s1, s2, 0, 0));
	}
}
