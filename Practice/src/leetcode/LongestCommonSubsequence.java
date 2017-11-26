package leetcode;

import java.util.Arrays;

public class LongestCommonSubsequence {

	
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
	
	public static void main(String arg[]) {
		String s1 = "abcbdcb";
		String s2 = "acbdbcb";
		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		System.out.println(lcs.longestCommonSubsequence(s1, s2));
	}
}
