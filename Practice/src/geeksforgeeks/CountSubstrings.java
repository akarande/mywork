package geeksforgeeks;
/**
 * Given a binary string of length N and an integer K, 
 * we need to find out how many substrings of this string 
 * are exist which contains exactly K ones.
 * Input : s = “10010”
 * K = 1
 * Output : 9
 * The 9 substrings containing one 1 are,
 * “1”, “10”, “100”, “001”, “01”, “1”, 
 * “10”, “0010” and “010”
 * @author akarande
 *
 */
public class CountSubstrings {
	
	public int count(String s, int k) {
		int n = s.length();
		int ans = 0;
		for(int i = 0; i < n; i++) {
			String temp = null;
			for(int j = i; j < n; j++) {
				temp = s.substring(i, j+1);
				if(isCorrectCount(temp, k)) {
					ans++;
				}
			}
		}
		return ans;
	}
	
	public boolean isCorrectCount(String s, int k) {
		int count = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '1') {
				count++;
			}
		}
		return count == k;
	}
	
	public static void main(String arg[]) {
		String s = "10010";
		int k = 1;
		CountSubstrings cs = new CountSubstrings();
		System.out.println(cs.count(s, k));
	}

}
