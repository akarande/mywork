package dp;

//Complexity 2^(m + n)
public class LongestCommonSubsequence {
	StringBuilder sb = new StringBuilder();
	int memo[][] = new int[10][10];
	
	public int lcs(String s1, String s2) {
		if (s1.isEmpty() || s2.isEmpty()) {
			return 0;
		}
		if (s1.charAt(0) == s2.charAt(0)) {
			return 1 + lcs(s1.substring(1), s2.substring(1));
		} else {
			int l1 = lcs(s1.substring(1), s2);
			int l2 = lcs(s1, s2.substring(1));
			return Math.max(l1, l2);
		}
	}

	public int reconstruct(String s1, String s2) {
		if (s1.isEmpty() || s2.isEmpty()) {
			return 0;
		}
		if (s1.charAt(0) == s2.charAt(0)) {
			return 1 + lcs(s1.substring(1), s2.substring(1));
		} else {
			int l1 = lcs(s1.substring(1), s2);
			int l2 = lcs(s1, s2.substring(1));
			return Math.max(l1, l2);
		}
	}
	
	public String lcsString(String s1, String s2) {
		if (s1.isEmpty() || s2.isEmpty()) {
			return "";
		}
		if (s1.charAt(0) == s2.charAt(0)) {
			return s1.charAt(0) + lcsString(s1.substring(1), s2.substring(1));
		} else {
			String l1 = lcsString(s1.substring(1), s2);
			String l2 = lcsString(s1, s2.substring(1));
			if (l1.length() < l2.length()) {
				return l2;
			} else {
				return l1;
			}
		}
	}
	
	
	
	public int lcs(String s1, String s2, int i, int j) {
		if(i >= s1.length() || j >= s2.length()) {
			return 0;
		} else{
			if(s1.charAt(i) == s2.charAt(j)) {
				if(memo[i][j] == -1) {
					sb.append(s2.charAt(j));
					memo[i][j] = (1 + lcs(s1, s2, i+1, j+1));
				}
			} else {
				if(memo[i][j] == -1) {
					memo[i][j] = Math.max(lcs(s1, s2, i+1, j), lcs(s1, s2, i, j+1));
				}
			}
			return memo[i][j];
		}
	}
	
	public void init() {
		for(int i = 0; i < memo.length; i++) {
			for(int j = 0; j < memo[i].length; j++) {
				memo[i][j] = -1;
			}
		}
	}
	
	public static void main(String arg[]) {
		String s1 = "ABCBDAB";
		String s2 = "BDCABA";
		LongestCommonSubsequence lcsObj = new LongestCommonSubsequence();
		lcsObj.init();
		System.out.println("Longest Subsequence: " + lcsObj.lcs(s1, s2, 0, 0));
		System.out.println("The string is: " + lcsObj.sb.toString());
	}
}
