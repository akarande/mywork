package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeReconstruction {

	
	class TreeNode {
		int val;
		TreeNode left, right;
		
		public TreeNode(int x) {val = x;}
	}
	void inorder(TreeNode root) {
		if(root == null) return;
		inorder(root.left);
		System.out.print(root.val + "\t");
		inorder(root.right);
	}
	void preorder(TreeNode root) {
		if(root == null) return;
		System.out.print(root.val + "\t");
		preorder(root.left);
		preorder(root.right);
	}
	void postorder(TreeNode root) {
		if(root == null) return;
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.val + "\t");
	}
	
	TreeNode addNode(TreeNode root, int val) {
		TreeNode node = new TreeNode(val);
		if(root == null) {return root = node;}
		List<TreeNode>queue = new ArrayList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode curr = queue.get(0);
			queue.remove(0);
			if(curr.left == null) {
				curr.left = node;
				break;
			} else {
				queue.add(curr.left);
			}
			if(curr.right == null) {
				curr.right = node;
				break;
			} else {
				queue.add(curr.right);
			}
		}
		return root;
	}
	
	int search(int arr[], int element) {
		for(int i = 0; i < arr.length; i++) {
			if(element == arr[i]) return i;
		}
		return -1;
	}
	
	public TreeNode buildFromPreIn(int preorder[], int p1, int p2, int inorder[], int i1, int i2) {
		if(i1 > i2 || p1 >= preorder.length) return null;
		TreeNode node = new TreeNode(preorder[p1]);
		int index = search(inorder, preorder[p1]);
		node.left = buildFromPreIn(preorder, p1 + 1, p1 + (index - i1), inorder, i1, index-1);
		node.right = buildFromPreIn(preorder, p1 + (index - i1) + 1, p2, inorder, index+1, i2);
		return node;
	}
	
	public TreeNode buildFromPostIn(int post[], int p1, int p2, int inorder[], int i1, int i2) {
		if(i1 > i2 || p2 < 0) return null;
		TreeNode node = new TreeNode(post[p2]);
		int index = search(inorder, post[p2]);
		node.left = buildFromPostIn(post, p1, p1 + (index - i1) - 1, inorder, i1, index-1);
		node.right = buildFromPostIn(post, p1 + (index - i1), p2-1, inorder, index+1, i2);
		return node;
	}
	
	public static void main(String arg[]) {
		BinaryTreeReconstruction btr = new BinaryTreeReconstruction();
		TreeNode root = null;
		root = btr.addNode(root, 4);
		root = btr.addNode(root, 3);
		root = btr.addNode(root, 6);
		root = btr.addNode(root, 1);
		root = btr.addNode(root, 5);
		root = btr.addNode(root, 7);
		root = btr.addNode(root, 8);
		root = btr.addNode(root, 9);
		root = btr.addNode(root, 10);
		btr.inorder(root);
		System.out.println();
		btr.preorder(root);
		System.out.println();
		btr.postorder(root);
		System.out.println();
		int inorder[] = {9, 1, 10, 3, 5, 4, 7, 6, 8};	
		int preorder[] = {4, 3, 1, 9, 10, 5, 6, 7, 8};	
		int postorder[] = {9, 10, 1, 5, 3, 7, 8, 6, 4};
		TreeNode newTree = null;
		newTree = btr.buildFromPreIn(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
		btr.postorder(newTree);
		System.out.println();
		newTree = btr.buildFromPostIn(postorder, 0, postorder.length-1, inorder, 0, inorder.length-1);
		btr.postorder(newTree);
		System.out.println();
		
	}
}
