package leetcode;

import java.util.Arrays;

public class RegexMatching {

	public boolean regexMacthing(String str, String regex) {
		int m = str.length(), n = regex.length();
		boolean dp[][] = new boolean[m+1][n+1];
		for(int i = 0; i <= m; i++) {
			Arrays.fill(dp[i], false);
		}
		dp[0][0] = true;
		for(int i = 1; i <= n; i++) {
			if(regex.charAt(i-1) == '*') {
				dp[0][i] = dp[0][i-2];
			}
		}
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				char s = str.charAt(i-1);
				char r = regex.charAt(j-1);
				if(s == r || r == '.') dp[i][j] = dp[i-1][j-1];
				else if(r == '*') {
					dp[i][j] = dp[i][j-2];
					if(regex.charAt(j-2) == s || regex.charAt(j-2) == '.') {
						dp[i][j] = dp[i][j] | dp[i-1][j];
					}
				} else {
					dp[i][j] = false;
				}
			}
		}
		return dp[m][n];
	}
	
	public static void main(String arg[]) {
		String str = "abbbcabb";
		String regex = "ab*c.b*";
		RegexMatching rm = new RegexMatching();
		System.out.println(rm.regexMacthing(str, regex));
	}
}
