package leetcode;

public class BinarySearchTree {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x) {
			val = x;
		}
	}
	
	TreeNode addNode(TreeNode root, int val) {
		TreeNode node = new TreeNode(val);
		if(root == null) {
			root = node;
		}
		else if(root.val > val) {
			root.left = addNode(root.left, val);
		} else {
			root.right = addNode(root.right, val);
		}
		return root;
	}
	
	int maxDepth(TreeNode root) {
		if(root == null) return 0;
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}
	
	void inorder(TreeNode root) {
		if(root == null) return;
		inorder(root.left);
		System.out.print(root.val + "\t");
		inorder(root.right);
	}
	
	
	public static void main(String arg[]) {
		TreeNode root = null;
		BinarySearchTree bst = new BinarySearchTree();
		root = bst.addNode(root, 4);
		root = bst.addNode(root, 6);
		root = bst.addNode(root, 9);
		root = bst.addNode(root, 8);
		root = bst.addNode(root, 3);
		root = bst.addNode(root, 1);
		bst.inorder(root);
		System.out.println("MAX DEPTH: " + bst.maxDepth(root));
	}
}
