package leetcode;

import java.util.HashMap;
import java.util.Map;

public class SortCharactersByFrequency {

	public String frequencySort(String s) {
        if(s == null || s.length() <= 1) return s;
        Map<Character, Integer>map = new HashMap<Character, Integer>();
        int max = Integer.MIN_VALUE;
        //Store the frequency of each character in a map
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            max = Math.max(max, map.get(c));
        }
        
        //Create array of strings where the row indicates the frequency of the word's occurrence
        String[] freq = new String[max+1];
        for(int i = 1; i < max+1; i++) {
            StringBuilder sb = new StringBuilder();
            for(Character c : map.keySet()) {
                if(map.get(c).intValue() == i) sb.append(c);
            }
            freq[i] = sb.toString();
        }
        
        //Now form the string
        StringBuilder ans = new StringBuilder();
        for(int i = max; i > 0; i--) {
            for(int k = 0; k < freq[i].length(); k++) {
                int j = i;
                while(j > 0) {
                    ans.append(freq[i].charAt(k));
                    j--;
                }
            }
        }
        return ans.toString();
    }
	
	public static void main(String arg[]) {
		SortCharactersByFrequency scby = new SortCharactersByFrequency();
		String s = "tree";
		System.out.println(scby.frequencySort(s));
	}
}
