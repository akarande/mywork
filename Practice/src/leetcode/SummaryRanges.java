package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SummaryRanges {

	public List<String> summaryRanges(int[] nums) {
        //int beginIndex, endIndex;
        List<String>range = new ArrayList<>();
        if(nums == null || nums.length == 0) return range;
        Stack<Integer>stack = new Stack<>();
        for(int i = 0; i < nums.length; i++) {
            if(stack.isEmpty()) stack.push(nums[i]);
            else if(stack.peek() + 1 == nums[i]) stack.push(nums[i]);
            else {
                if(!stack.isEmpty() && stack.peek() + 1 != nums[i]) {
                    int end = stack.peek();
                    int begin = -1;
                    while(!stack.isEmpty()) {
                        begin = stack.peek();
                        stack.pop();
                    }
                    stack.push(nums[i]);
                    if(begin == -1 || end == begin) range.add(String.valueOf(end));
                    else range.add(String.valueOf(begin) + "->" + String.valueOf(end));
                }
            }
        }
        if(!stack.isEmpty()) {
        	int e = stack.peek();
        	int b = -1;
        	while(!stack.isEmpty()) {
        		b = stack.peek();
        		stack.pop();
        	}
        	if(e == b) range.add(String.valueOf(e));
        	else range.add(String.valueOf(b) + "->" + String.valueOf(e));
        }
        return range;
    }
	
	public static void main(String arg[]) {
		SummaryRanges sr = new SummaryRanges();
		int nums[] = {0,2,3,4,6,8,9};//{0,1,2,4,5,7};
		System.out.println(sr.summaryRanges(nums).toString());
		System.out.println();
	}
}
