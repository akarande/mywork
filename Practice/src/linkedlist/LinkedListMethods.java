package linkedlist;

public class LinkedListMethods {

	
	public Node add(Node root, int value) {
		Node newNode = new Node(value);
		if(root == null) {
			root = newNode;
		} else {
			Node temp = root;
			while(temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(newNode);
		}
		return root;
	}
	
	public Node reverseIterative(Node root) {
		Node prev = null;
		Node curr = root;
		Node next = null;
		while(curr != null) {
			next = curr.getNext();
			curr.setNext(prev);
			prev = curr;
			curr = next;
		}
		root = prev;
		return root;
	}
	
	public Node reverseRecursive(Node root) {
		if(root == null || root.getNext() == null) {
			return root;
		} else {
			Node remaining = reverseRecursive(root.getNext());
			root.getNext().setNext(root);
			root.setNext(null);
			return remaining;
		}
	}
	
	public void printList(Node root) {
		while(root != null) {
			System.out.println(root.getValue());
			root = root.getNext();
		}
	}
	
	public Node deleteNode(Node root, int value) {
		if(root == null) {
			return root;
		} 
		if(root.getValue() == value) {
			root = root.getNext();
		} else {
			Node curr = root;
			while(curr.getNext() != null) {
				if(curr.getNext().getValue() == value) {
					Node temp = curr.getNext().getNext();
					curr.setNext(temp);
					break;
				} else {
					curr = curr.getNext();
				}
			}
		}
		return root;
	}
	
	public static void main(String arg[]) {
		Node root = null;
		int i = 1;
		LinkedListMethods llm = new LinkedListMethods();
		while(i <= 10) {
			root = llm.add(root, i);
			i++;
		}
		//root = llm.reverseIterative(root);
		//root = llm.reverseRecursive(root);
		root = llm.deleteNode(root, 23);
		llm.printList(root);
	}
}
