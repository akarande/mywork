package leetcode;

public class ValidParenthesis {

	public boolean checkValidString(String s) {
        return solve(s, 0, 0);
    }
    boolean solve(String s, int index, int count) {
        if(count < 0) return false;
        for(int i = index; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') count++;
            else if(c == ')') {
                if(count <= 0) return false;
                count--;
            } else {
                return solve(s, i+1, count) || solve(s, i+1, count+1) || solve(s, i+1, count-1);
            }
        }
        return count == 0;
    }
    
    public static void main(String arg[]) {
    	ValidParenthesis vp = new ValidParenthesis();
    	String s = "((*)))";
    	System.out.println(vp.checkValidString(s));
    }
}
