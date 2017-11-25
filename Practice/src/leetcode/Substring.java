package leetcode;

import java.util.Arrays;

public class Substring {

	private final int PRIME = 101;
	/**
	 * Brute Force
	 * O(m*n) complexity simple string search where m is the length 
	 * of the original string and n is the length of the pattern.
	 * @param str
	 * @param subStr
	 * @return
	 */
	public int substring(String str, String subStr) {
		for(int i = 0; i < str.length(); i++) {
			for(int j = 0; j < subStr.length();) {
				if(str.charAt(i+j) == subStr.charAt(j)) {
					while(j < subStr.length() && (i+j) < str.length() 
							&& str.charAt(i + j) == subStr.charAt(j)) {
						j++;
					}
					if(j >= subStr.length()) return i;	//Found match at i;
				} else {
					break;
				}
			}
		}
		return -1;
	}
	
	/**
	 * Knuth-Morris-Pratt(KMP) method to search for a substring
	 * Complexity O(m + n)
	 * @param str
	 * @param subStr
	 * @return
	 */
	public int substringKMP(String str, String subStr) {
		if(str == null || subStr == null || str.length() == 0 || subStr.length() == 0) return -1;
		int kmp[] = new int[subStr.length()];
		Arrays.fill(kmp, 0);
		//Creating the array for repositioning
		for(int j = 0, i = 1; i < subStr.length();) {
			if(subStr.charAt(j) == subStr.charAt(i)) {
				kmp[i] = j + 1;
				j++;
				i++;
			} else {
				if(j == 0) {
					kmp[i] = 0;
					i++;
					continue;
				} else {
					j = kmp[j-1];
				}
			}
		}
		//The actual substring search
		for(int j = 0, i = 0; i < str.length();) {
			if(str.charAt(i) == subStr.charAt(j)) {
				i++;
				j++;
			} else {
				if(j == 0) {
					i++;
				} else {
					j = kmp[j-1];
				}
			}
			if(j >= subStr.length()) return i-j;
		}
		return -1;
	}
	
	
	//Rabin-Karp
	public int substringRabinKarp(String str, String pattern) {
		long patternHash = getHash(pattern);
		for(int i = 0; i < str.length(); i++) {
			StringBuilder curr = new StringBuilder();
			for(int j = 0; j < pattern.length() && (i + j) < str.length(); j++) {
				curr.append(str.charAt(i + j));
			}
			if(getHash(curr.toString()) == patternHash && compare(curr.toString(), pattern)) return i;
		}
		return -1;
	}
	
	long getHash(String s) {
		long hash = 0;
		for(int i = 0; i < s.length(); i++) {
			hash = hash + (long)(s.charAt(i)* Math.pow(PRIME, i));
		}
		return hash;
	}
	
	long getRecalcuatedHash(String s, long previousHash, char oldChar) {
		long hash = previousHash - oldChar;
		previousHash = previousHash/PRIME;
		hash += previousHash*(s.charAt(s.length()-1))*Math.pow(PRIME, s.length()-1);
		return hash;
	}
	
	String getSubString(String s, int start, int end) {
		StringBuilder ans = new StringBuilder();
		for(int i = start; i <= end; i++) {
			ans.append(s.charAt(i));
		}
		return ans.toString();
	}
	
	boolean compare(String s1, String s2) {
		if(s1 == null || s2 == null 
				|| s1.length() == 0 || s2.length() == 0 
				|| s1.length() != s2.length()) return false;
		for(int i = 0; i < s1.length(); i++) {
			if(s1.charAt(i) != s2.charAt(i)) return false;
		}
		return true;
	}
	
	public static void main(String arg[]) {
		String s1 = "abxabcdabcaby";
		String s2 = "abcdabca";
		Substring ss = new Substring();
		System.out.println("KMP Match found at " + ss.substringKMP(s1, s2));
		System.out.println("REG Match found at " + ss.substring(s1, s2));
		System.out.println("RBK Match found at " + ss.substringRabinKarp(s1, s2));
	}
}
