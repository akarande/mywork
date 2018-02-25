package leetcode;

import java.util.Stack;

public class LargestRectangleHistogram {

	public int largestRectangleArea(int[] heights) {
        Stack<Integer>stack = new Stack<>();
        int currArea = 0;
        int i, maxArea = 0;
        for(i = 0; i < heights.length;) {
            //Push only when stack is empty or the new height is greater than or equal to existing stack top
            if(stack.isEmpty() || heights[stack.peek()] <= heights[i]) stack.push(i++);
            else  {
                //If the new height is smaller than the top of the stack then pop
                int top = stack.pop();
                //If stack is empty then the area will just be the current height * current value of i
                if(stack.isEmpty()) {
                    currArea = heights[top] * i;
                } else {
                    //The area will be the (right side min value - left side minimum - 1) * (current top height)
                    currArea = heights[top] * (i - stack.peek() - 1);
                }
                maxArea = Math.max(currArea, maxArea);
            }
        }
        while(!stack.isEmpty()) {
            int top = stack.pop();
            if(stack.isEmpty()) currArea = heights[top] * i;
            else currArea = heights[top] * (i - stack.peek() - 1);
            maxArea = Math.max(maxArea, currArea);
        }
        return maxArea;
    }
	
	public static void main(String arg[]) {
		LargestRectangleHistogram lrh = new LargestRectangleHistogram();
		int[] heights = {2,1,5,6,2,3};
		System.out.println(lrh.largestRectangleArea(heights));
	}
}
