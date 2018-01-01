package leetcode;

public class LongestPalindromeSubstring {

	public String longestPalindrome(String s) {
        int n = s.length();
        int begin = 0;
        int currLength = 0;
        for(int i = 0; i < n; i++) {
            if(isPalindrome(s, i - currLength - 1, i)) {
                begin = i - currLength - 1;
                currLength = currLength + 2;
            } else if(isPalindrome(s, i - currLength, i)) {
                begin = i - currLength;
                currLength = currLength + 1;
            }
        }
        return new String(s.toCharArray(), begin, currLength);
    }
    
    boolean isPalindrome(String s, int x, int y) {
        if(x < 0) return false;
        while(x < y) {
            if(s.charAt(x) != s.charAt(y)) return false;
            x++;
            y--;
        }
        return true;
    }
    
    public static void main(String arg[]) {
    	String s = "abab";
    	LongestPalindromeSubstring lps = new LongestPalindromeSubstring();
    	System.out.println(lps.longestPalindrome(s));
    }
}
