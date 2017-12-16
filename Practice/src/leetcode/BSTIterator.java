package leetcode;

import java.util.Stack;

public class BSTIterator {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int x) {
			val = x;
			this.left = null;
			this.right = null;
		}
	}
	
    Stack<TreeNode>ss = null;
    public BSTIterator(TreeNode root) {
        ss = new Stack<>();
        TreeNode curr = root;
        while(curr != null) {
            ss.push(curr);
            curr = curr.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !ss.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode curr = ss.peek();
        ss.pop();
        if(curr.right != null) {
            ss.push(curr.right);
            TreeNode temp = curr.right;
            while(temp.left != null) {
                ss.push(temp.left);
                temp = temp.left;
            }
        }
        return curr.val;
    }
}