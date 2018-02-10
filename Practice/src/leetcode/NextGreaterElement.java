package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {

	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer>stack = new Stack<>();
        Map<Integer, Integer>map = new HashMap<>();
        for(int i = nums2.length-1; i >= 0; i--) {
            while(!stack.isEmpty() && nums2[i] > stack.peek()) stack.pop();
            map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums2[i]);
        }
        
        int ans[] = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
	
	public static void main(String arg[]) {
		NextGreaterElement nge = new NextGreaterElement();
		int nums1[] = {4,1,2};
		int nums2[] = {1,3,4,2};
		Arrays.stream(nge.nextGreaterElement(nums1, nums2)).forEach(e -> System.out.print(e + " "));
	}
}
