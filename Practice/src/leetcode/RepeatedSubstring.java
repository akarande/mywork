package leetcode;

public class RepeatedSubstring {

	boolean isSubString(String s) {
        int n = s.length();
        for(int i = 1; i < n; i++) {
            if(n%i == 0 && s.startsWith(s.substring(i))) return true;
        }
        return false;
    }
	
	public boolean repeatedSubstringPattern(String s) {
		if(s == null || s.length() <= 1) return false;
		return isSubString(s);
	}
	
	public static void main(String arg[]) {
		RepeatedSubstring rs = new RepeatedSubstring();
		String s = "abcabcabc";
		System.out.println(rs.repeatedSubstringPattern(s));
	}
}
