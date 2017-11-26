package leetcode;

import java.util.ArrayList;
import java.util.List;

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
	
	void levelOrderTraversal(TreeNode root) {
		if(root == null) return;
		List<TreeNode>queue = new ArrayList<>();
		queue.add(root);
		TreeNode curr = root;
		int k = 0;
		List<TreeNode>currQ = new ArrayList<>();
		do {
			currQ.clear();
			while(k < queue.size()) {
				curr = queue.get(k);
				System.out.print(curr.val + "\t");
				k++;
				if(curr.left != null) currQ.add(curr.left);
				if(curr.right != null) currQ.add(curr.right);
			}
			System.out.println();
			queue.addAll(currQ);
		} while(!currQ.isEmpty());
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
		root = bst.addNode(root, 2);
		root = bst.addNode(root, 5);
		root = bst.addNode(root, 7);
		bst.inorder(root);
		System.out.println("MAX DEPTH: " + bst.maxDepth(root));
		System.out.println("Level Order Traversal");
		bst.levelOrderTraversal(root);
	}
}
