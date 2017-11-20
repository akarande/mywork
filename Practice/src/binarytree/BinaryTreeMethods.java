package binarytree;

import java.util.Stack;

/**
 * Basic Methods for a Binary Tree
 * @author akarande
 *
 */
public class BinaryTreeMethods {
	
	public BinaryNode addNode(BinaryNode root, int value) {
		//If no tree exist then make the current node as root.
		BinaryNode head = root;
		if(head == null) {
			head = new BinaryNode(value);
			root = head;
		}
		//Check if value is smaller than the current head.
		if(head.getValue() > value) {
			if(head.getLeft() != null) {
				addNode(head.getLeft(), value);
			} else {
				head.setLeft(new BinaryNode(value));
			}
		}
		//Check if value is greater than the current head.
		if(head.getValue() < value) {
			if(head.getRight() != null) {
				addNode(head.getRight(), value);
			} else {
				head.setRight(new BinaryNode(value));
			}
		}
		return root;
	}
	
	public void inOrder(BinaryNode root) {
		if(root == null) {
			return;
		} else {
				inOrder(root.getLeft());
				System.out.println(root.getValue());
				inOrder(root.getRight());
		}
	}
	
	public void inOrderIterative(BinaryNode root) {
		Stack<BinaryNode> s = new Stack<BinaryNode>();
		BinaryNode curr = root;
		s.push(curr);
		while(curr != null || !s.isEmpty()) {
			if(curr != null) {
				s.push(curr);
				curr = curr.getLeft();
			} else {
				curr = s.pop();
				System.out.println(curr.getValue());
				curr = curr.getRight();
			}
		}
	}
	
	public void preOrder(BinaryNode root) {
		if(root == null) {
			return;
		} else {
			System.out.println(root.getValue());
			preOrder(root.getLeft());
			preOrder(root.getRight());
		}
	}
	
	public void preOrderIterative(BinaryNode root) {
		if(root == null) {
			return;
		} else {
			BinaryNode curr = root;
			Stack<BinaryNode>arr = new Stack<>();
			if(curr != null) {
				arr.push(curr);
			}
			while(!arr.isEmpty()) {
				BinaryNode bn = arr.pop();
				System.out.println(bn.getValue());
				if(bn.getRight() != null) {
					arr.push(bn.getRight());
				}
				if(bn.getLeft() != null) {
					arr.push(bn.getLeft());
				}
			}
		}
	}
	
	
	public void postOrder(BinaryNode root) {
		if(root == null) {
			return;
		} else {
			postOrder(root.getLeft());
			postOrder(root.getRight());
			System.out.println(root.getValue());
		}
	}
	
	public void postOrderIterative(BinaryNode root) {
		if(root == null) {
			return;
		} else {
			BinaryNode visited = null;
			BinaryNode curr = root;
			Stack<BinaryNode> ss = new Stack<>();
			while(curr != null || !ss.isEmpty()) {
				if(curr != null) {
					ss.push(curr);
					curr = curr.getLeft();
				} else {
					BinaryNode peek = ss.peek();
					if(peek.getRight() != null && visited != peek.getRight()) {
						curr = peek.getRight();
					} else {
						System.out.println(peek.getValue());
						visited = ss.pop();
					}
				}
			}
		}
	}
	
	public static void main(String arg[]) {
		BinaryTreeMethods btm = new BinaryTreeMethods();
		BinaryNode root = btm.addNode(null, 4);
		btm.addNode(root, 3);
		btm.addNode(root, 2);
		btm.addNode(root, 1);
		btm.addNode(root, 5);
		root = btm.addNode(root, 6);
		//btm.inOrderIterative(root);
		btm.postOrderIterative(root);
	}
}
