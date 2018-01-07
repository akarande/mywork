package leetcode;

import java.util.Arrays;

public class PatternMatching {

	public boolean patternMatching(String str, String pattern) {
		int m = str.length(), n = pattern.length();
		boolean dp[][] = new boolean[m+1][n+1];
		for(int i = 0; i <= m; i++) {
			Arrays.fill(dp[i], false);
		}
		dp[0][0] = true;
		for(int i = 1; i <= n; i++) {
			if(pattern.charAt(i-1) == '*') dp[0][i] = dp[0][i-1];
		}
		
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				char c = str.charAt(i-1);
				char p = pattern.charAt(j-1);
				if(c == p || p == '?') {
					dp[i][j] = dp[i-1][j-1];
				} else if(p == '*') {
					dp[i][j] = dp[i-1][j] || dp[i][j-1];
				} else {
					dp[i][j] = false;
				}
			}
		}
		return dp[m][n];
	}
	
	public static void main(String arg[]) {
		PatternMatching pm = new PatternMatching();
		String str = "abcabcdcceb";
		String pattern = "aba?cd*b";
		System.out.println(pm.patternMatching(str, pattern));
	}
}
