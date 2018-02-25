package leetcode;

public class LongestRepeatingCharacterReplacement {

	public int characterReplacement(String s, int k) {
        if(s == null || s.length() == 0) return 0;
        int arr[] = new int[26];
        int n = s.length();
        int mx = 0;
        int mxFrequency = 0;
        int begin = 0;
        for(int i = 0; i < n; i++) {
            int index = (int)(s.charAt(i) - 'A');
            arr[index]++;
            mxFrequency = Math.max(mxFrequency, arr[index]);
            while(i - begin - mxFrequency + 1 > k) {
                int x = (int)(s.charAt(begin) - 'A');
                arr[x]--;
                begin++;
            }
            mx = i - begin + 1;
        }
        return mx;
    }
	
	public static void main(String arg[]) {
		LongestRepeatingCharacterReplacement lrcr = new LongestRepeatingCharacterReplacement();
		String s = "AABABBA";
		int k = 1;
		System.out.println(lrcr.characterReplacement(s, k));
	}
}
