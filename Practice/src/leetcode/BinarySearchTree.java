package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
	
	/**
	 * Level order traversal with 2 loops
	 * @param root
	 */
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
	
	/**
	 * Level order traversal with one loop
	 * @param root
	 */
	void levelOrderTraversal2(TreeNode root) {
		List<TreeNode>queue = new ArrayList<>();
		queue.add(root);
		int i = 0;
		List<TreeNode>temp = new ArrayList<>();
		while(i < queue.size()) {
			TreeNode curr = queue.get(i++);
			System.out.print(curr.val + "\t");
			if(curr.left != null) temp.add(curr.left);
			if(curr.right != null) temp.add(curr.right);
			if(i >= queue.size()) {
				queue.addAll(temp);
				temp.clear();
				System.out.println();
			}
		}
	}
	
	
	void preorder(TreeNode root) {
		if(root == null) return;
		System.out.print(root.val + "\t");
		preorder(root.left);
		preorder(root.right);
	}
	
	void preorderIterative(TreeNode root) {
		if(root == null) return;
		TreeNode curr;
		Stack<TreeNode>stack = new Stack<>();
		stack.add(root);
		while(!stack.isEmpty()) {
			curr = stack.pop();
			System.out.print(curr.val + "\t");
			if(curr.right != null) stack.push(curr.right);
			if(curr.left != null) stack.push(curr.left);
		}
	}
	
	void postorder(TreeNode root) {
		if(root == null) return;
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.val + "\t");
	}
	
	void postorderIterative(TreeNode root) {
		if(root == null) return;
		TreeNode curr;
		Stack<TreeNode>stack = new Stack<>();
		List<TreeNode>traverse = new ArrayList<>();
		stack.add(root);
		while(!stack.isEmpty()) {
			curr = stack.pop();
			traverse.add(0, curr);
			if(curr.left != null) stack.push(curr.left);
			if(curr.right != null) stack.push(curr.right);
		}
		traverse.stream().forEach(e -> System.out.print(e.val + "\t"));
	}
	
	void postorderIterative2(TreeNode root) {
		if(root == null) return;
		TreeNode curr, prev = null;
		Stack<TreeNode>stack = new Stack<>();
		curr = root;
		while(!stack.isEmpty() || curr != null) {
			if(curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			else {
				TreeNode top = stack.peek();
				if(top.right != null && top.right != prev) {
					curr = top.right;
				} else {
					System.out.print(top.val + "\t");
					prev = stack.pop();
				}
			}
		}
	}
	
	void inorder(TreeNode root) {
		if(root == null) return;
		inorder(root.left);
		System.out.print(root.val + "\t");
		inorder(root.right);
	}
	
	void inorderIterative(TreeNode root) {
		if(root == null) return;
		Stack<TreeNode>stack = new Stack<>();
		TreeNode curr = root;
		while(!stack.isEmpty() || curr != null) {
			if(curr != null) {
				stack.push(curr);
				curr = curr.left;
			} else {
				curr = stack.pop();
				System.out.print(curr.val + "\t");
				curr = curr.right;
			}
		}
	}
	
	TreeNode search(TreeNode root, int val) {
		if(root == null) return root;
		if(root.val == val) return root;
		else if(root.val > val) return search(root.left, val);
		else return search(root.right, val);
	}
	
	TreeNode inorderSuccessor(TreeNode root, int val) {
		TreeNode curr = search(root, val);
		//Node has right sub-tree
		if(curr.right != null) {
			TreeNode t = curr.right;
			while(t.left != null) {
				t = t.left;
			}
			return t;
		} else {
			//Node does not have right sub-tree
			TreeNode successor = null;
			TreeNode ancestor = root;
			while(ancestor != curr) {
				if(ancestor.val > curr.val) {
					successor = ancestor;
					ancestor = ancestor.left;
				} else {
					ancestor = ancestor.right;
				}
			}
			return successor;
		}
		
	}
	
	boolean isBST(TreeNode root, int minRange, int maxRange) {
		if(root == null) return true;
		if(root.val <= minRange && root.val > maxRange) return false;
		return isBST(root.left, minRange, root.val) && isBST(root.right, root.val, maxRange);
	}
	
	TreeNode minValue(TreeNode root) {
		if(root == null) return root;
		while(root.left != null) {
			root = root.left;
		}
		return root;
	}
	
	TreeNode deleteNode(TreeNode root, int val) {
		if(root == null) return root;
		else if(root.val > val) {
			root.left = deleteNode(root.left, val);
		} else if(root.val < val) {
			root.right = deleteNode(root.right, val);
		} else {
			if(root.val == val) {
				//Both children are null
				if(root.left == null && root.right == null) {
					root = null;
				} else if(root.left == null && root.right != null) {
					//Only left is null
					root = root.right;
				} else if(root.left != null && root.right == null) {
					//Only right is null
					root = root.left;
				} else {
					//Both left and right are not null, find inorder sucessor
					TreeNode curr = minValue(root.right);
					root.val = curr.val;
					root.right = deleteNode(root.right, curr.val);
				}
			}
		}
		return root;
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
		//bst.inorder(root);
		//System.out.println("MAX DEPTH: " + bst.maxDepth(root));
		//System.out.println("Level Order Traversal");
		//bst.levelOrderTraversal2(root);
		//bst.preorder(root);
		//System.out.println();
		//bst.preorderIterative(root);
		/*bst.postorder(root);
		System.out.println();
		bst.postorderIterative(root);
		System.out.println();
		bst.postorderIterative2(root);
		*/
		bst.inorder(root);
		System.out.println();
		bst.inorderIterative(root);
	}
}
