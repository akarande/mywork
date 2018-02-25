package leetcode;

public class LongestSubstringWithKCharacters {

	public int longestSubstring(String s, int k) {
        if(s == null || s.length() == 0 || k > s.length()) return 0;
        if(k <= 1) return s.length();
        int n = s.length();
        int arr[] = new int[26];

        //Fill the array with frequency of each element
        for(int i = 0; i < s.length(); i++) arr[(int)(s.charAt(i) - 'a')]++;

        char toBeSplit = 0;
        for(int i = 0; i < 26; i++) {
            if(arr[i] > 0 && arr[i] < k) {
                toBeSplit = (char)(i + 'a');
                break;
            }
        }
        if(toBeSplit == 0) return n;
        String rest[] = s.split(toBeSplit + "");
        int ans = 0;
        for(String t : rest) {
            ans = Math.max(ans, longestSubstring(t, k));
        }
        return ans;
    }
	
	public static void main(String arg[]) {
		LongestSubstringWithKCharacters lswkc = new LongestSubstringWithKCharacters();
		String s = "aaabb";
		int k = 3;
		System.out.println(lswkc.longestSubstring(s, k));
	}
}
