package leetcode;

import java.util.Stack;

public class RecoverTree {
	
	class TreeNode {
		TreeNode left, right;
		int val;
		public TreeNode(int x) { val = x; }
	}

	public void recoverTree(TreeNode root) {
        TreeNode first = null;
        TreeNode second = null;
        TreeNode prev = null;
        TreeNode curr = root;
        Stack<TreeNode>ss = new Stack<>();
        while(curr != null || !ss.isEmpty()) {
            if(curr != null) {
                ss.push(curr);
                curr = curr.left;
            } else {
                curr = ss.pop();
                if(prev != null && prev.val > curr.val) {
                    if(first == null) first = prev;
                    second = curr;
                }
                prev = curr;
                curr = curr.right;
            }
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}
