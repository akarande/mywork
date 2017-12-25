package leetcode;

public class ValidPalindrome {

	public boolean validPalindrome(String s) {
        int arr[] = new int[30];
        int n = s.length();
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            arr[c - 'a']++;
        }
        int c = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] == 1) c++;
        }
        if((n%2 == 0 && c == 1) || (n%2 == 0 && c == 0) 
        		|| (n%2 == 1 && c == 2) || (n%2 == 1 && c == 1)) return true;
        return false;
    }
	
	public static void main(String arg[]) {
		ValidPalindrome vp = new ValidPalindrome();
		String s = "abba";
		System.out.println(vp.validPalindrome(s));
	}
}
