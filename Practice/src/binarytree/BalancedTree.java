package binarytree;


public class BalancedTree {

	class TreeNode {
		int val;
		int height;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int x) {
			val = x;
		}
	}
	
	TreeNode rotateRight(TreeNode root) {
		TreeNode newRoot = root.left;
		root.left = newRoot.right;
		newRoot.right = root;
		root.height = 1 + Math.max(root.left.height, root.right.height);
		newRoot.height = 1 + Math.max(newRoot.left.height, newRoot.right.height);
		return newRoot;
	}
	
	TreeNode rotateLeft(TreeNode root) {
		TreeNode newRoot = root.right;
		root.right = newRoot.left;
		newRoot.left = root;
		root.height = 1 + Math.max(root.left.height, root.right.height);
		newRoot.height = 1 + Math.max(newRoot.left.height, newRoot.right.height);
		return newRoot;
	}
	
	public TreeNode insertIntoBalancedTree(TreeNode root, int val) {
		TreeNode node = new TreeNode(val);
		if(root == null) root = node;
		if(root.val > val) {
			root.left = insertIntoBalancedTree(root.left, val);
		} else {
			root.right = insertIntoBalancedTree(root.right, val);
		}
		int balance = root.left.height - root.right.height;
		if(balance > 1) {
			if(root.left.left.height > root.left.right.height) {//LL condition
				return rotateRight(root.left);
			} else {	//LR condition
				root.left = rotateLeft(root.left);
				return rotateRight(root);
			}
		}
		if(balance < -1) {
			if(root.right.right.height > root.right.left.height) {// RR condition
				return rotateLeft(root.right);
			} else {	//RL condition
				root.right = rotateRight(root.right);
				return rotateLeft(root);
			}
		}
		root.height = 1 + Math.max(root.left.height, root.right.height);
		return root;
	}
	
}
