package general;

public class EditDistance {

	
	int editDistance(String s1, String s2) {
		if(s1 == null || s1.length() == 0) return s2.length();
		if(s2 == null || s2.length() == 0) return s1.length();
		else if(s1.charAt(s1.length()-1) == s2.charAt(s2.length()-1)) 
			return editDistance(s1.substring(0, s1.length()-1), s2.substring(0, s2.length()-1));
		else {
			int d1 = editDistance(s1, s2.substring(0, s2.length()-1));	//Remove
			int d2 = editDistance(s1.substring(0, s1.length()-1), s2);	//Insert
			int d3 = editDistance(s1.substring(0, s1.length()-1), s2.substring(0, s2.length()-1));	//Replace
			return 1 + Math.min(d1, Math.min(d2, d3));
		}
	}
	
	int editDistance2(String s1, String s2) {
		int dp[][] = new int[s1.length()+1][s2.length()+1];
		for(int i = 0; i < dp.length; i++) {
			dp[i][0] = i;
		}
		for(int i = 0; i < dp[0].length; i++) {
			dp[0][i] = i;
		}
		
		for(int i = 1; i < dp.length; i++) {
			for(int j = 1; j < dp[0].length; j++) {
				char c1 = s1.charAt(i-1);
				char c2 = s2.charAt(j-1);
				if(c1 == c2) {
					dp[i][j] = dp[i-1][j-1];
				} else {
					dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));
				}
			}
		}
		return dp[s1.length()][s2.length()];
	}
	
	public static void main(String arg[]) {
		String s1 = "abbed";
		String s2 = "adccdd";
		EditDistance ed = new EditDistance();
		System.out.println(ed.editDistance(s1, s2));
		System.out.println(ed.editDistance2(s1, s2));
	}
}
