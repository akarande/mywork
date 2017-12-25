package leetcode;

import java.util.Stack;

public class LongestValidParenthesis {

	public int longestValidParentheses(String s) {
        return validCount(s);
    }
    int validCount(String s) {
        Stack<Integer>ss = new Stack<>();
        //Initialize the stack with -1
        ss.push(-1);
        //Initialize count to zero
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') ss.push(i); //For an opening parenthesis push the index on stack
            else {  //For a closing parenthesis pop the top element
                ss.pop();
                //If the stack is not empty then get the length of the current valid sequence and update if that is the longest
                if(!ss.isEmpty()) count = Math.max(count, (i - ss.peek()));
                //Push if the stack became empty since the next valid sequence will begin from here.
                else ss.push(i);
            }
        }
        return count;
    }
    
    public static void main(String arg[]) {
    	LongestValidParenthesis lvp = new LongestValidParenthesis();
    	String s = "))(())((()()()())";
    	System.out.println(lvp.longestValidParentheses(s));
    }
}
