package general;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	List<String>visited = null;
	public void permuteRecursive(String s, int n) {
		if(n == 0) {
			if(!visited.contains(s)) {
				System.out.println(s);
				visited.add(s);
			}
			return;
		} else {
			for(int i = 0; i < s.length(); i++) {
				s = swap(s, i, n-1);
				permuteRecursive(s, n-1);
				s = swap(s, i, n-1);
			}
		}
	}
	
	public String swap(String s, int i, int j) {
		char[] c = s.toCharArray();
		char t = c[i];
		c[i] = c[j];
		c[j] = t;
		return new String(c);
	}
	
	public static void main(String arg[]) {
		Permutations pmt = new Permutations();
		pmt.visited = new ArrayList<>();
		pmt.permuteRecursive("abc", 3);
	}
}
