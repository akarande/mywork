package leetcode;

public class DecodeWays {

	public int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        int n = s.length();
        int memo[] = new int[n+1];
        memo[0] = 1;
        memo[1] = s.charAt(0) == '0' ? 0 : 1;
        for(int i = 2; i <= n; i++) {
            int a1 = Integer.valueOf(s.substring(i-1, i));
            int a2 = Integer.valueOf(s.substring(i-2, i));
            if(a1 > 0 && a1 < 10) memo[i] += memo[i-1];
            if(a2 > 9 && a2 < 27) memo[i] += memo[i-2];
        }
        return memo[n];
    }
	
	public static void main(String arg[]) {
		DecodeWays dw = new DecodeWays();
		String s = "1021";
		System.out.println(dw.numDecodings(s));
	}
}
