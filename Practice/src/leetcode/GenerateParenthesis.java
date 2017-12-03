package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

	public List<String> generateParenthesis(int n) {
		List<String>result = new ArrayList<>();
		solve(new String(), 0, 0, n, result);
		return result;
	}
	
	void solve(String curr, int open, int close, int total, List<String> result) {
		if(curr.length() == 2*total) {
			result.add(curr);
			return;
		}
		if(open < total) {
			solve(curr + '(', open + 1, close, total, result);
		}
		if(open > close) {
			solve(curr + ')', open, close + 1, total, result);
		}
	}
	
	public static void main(String arg[]) {
		GenerateParenthesis gp = new GenerateParenthesis();
		int k = 3;
		gp.generateParenthesis(k).stream().forEach(e -> System.out.print(e.toString() + " "));
	}
}
