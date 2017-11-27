package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * EG: input: "aab"
 * output: [ ["aa","b"], ["a","a","b"] ]
 * @author akarande
 *
 */
public class PalindromePartitioning {
	public List<List<String>> partition(String s) {
        List<List<String>>result = new ArrayList<>();
        solve(s, 0, new ArrayList<>(), result);
        return result;
    }
    
    void solve(String s, int pos, List<String> currList, List<List<String>> result) {
        if(pos == s.length()) {
            result.add(new ArrayList<String>(currList));
        } else {
            for(int i = pos; i < s.length(); i++) {
                if(isPalindrome(s, pos, i)) {
                    currList.add(s.substring(pos, i+1));
                    solve(s, i+1, currList, result);
                    currList.remove(currList.size() - 1);
                }
            }
        } 
    }
    
    boolean isPalindrome(String s, int x, int y) {
        while(x < y) {
            if(s.charAt(x) != s.charAt(y)) return false;
            x++;
            y--;
        }
        return true;
    }
    
    public static void main(String arg[]) {
    	String s = "aab";
    	PalindromePartitioning pp = new PalindromePartitioning();
    	pp.partition(s).stream().forEach(e -> System.out.print(e.toString() + " "));
    }
}
