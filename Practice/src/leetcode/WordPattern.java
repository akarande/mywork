package leetcode;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

	public boolean wordPattern(String pattern, String str) {
        Map<String, Character>map = new HashMap<>();
        String s[] = str.split(" ");
        if(pattern.length() != s.length) return false;
        for(int i = 0; i < pattern.length(); i++) {
            char curr = pattern.charAt(i);
            if(!map.containsKey(s[i])) {
                if(map.containsValue(curr) && !map.containsKey(s[i])) {
                    return false;
                }
                map.put(s[i], curr);
            } else {
                Character value = map.get(s[i]);
                if(curr != value) return false;
            }
        }
        return true;
    }
	
	public static void main(String arg[]) {
		WordPattern wp = new WordPattern();
		String pattern = "e";
		String str = "eureka";
		System.out.println(wp.wordPattern(pattern, str));
	}
}
