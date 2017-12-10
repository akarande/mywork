package leetcode;

public class LongestPalindromicSubsequence {
	
	/**
	 * Fill bottom up for easier operations
	 * @param s
	 * @return
	 */
	public int longestPlaindromicSubsequence(String s) {
		int n = s.length();
		int dp[][] = new int[n][n];
		for(int i = n-1; i >= 0; i--) {
			dp[i][i] = 1;
			for(int j = i+1; j < n; j++) {
				if(s.charAt(i) == s.charAt(j)) dp[i][j] = 2 + dp[i+1][j-1];
				else dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
			}
		}
		return dp[0][n-1];
	}
	
	public static void main(String arg[]) {
		String s = "bbbab";
		LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
		System.out.println(lps.longestPlaindromicSubsequence(s));
	}
}
