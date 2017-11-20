package linkedlist;

public class DoublyLinkedListMethods {
	
	public DoublyNode add(DoublyNode root, int value) {
		DoublyNode newNode = new DoublyNode(value);
		if(root == null) {
			root = newNode;
		} else {
			DoublyNode curr = root;
			while(curr.getNext() != null) {
				curr = curr.getNext();
			}
			if(curr.getNext() == null) {
				curr.setNext(newNode);
				newNode.setPrevious(curr);
			}
		}
		return root;
	}
	
	public DoublyNode reverse(DoublyNode root) {
		DoublyNode curr = root;
		DoublyNode temp = null;
		while(curr != null) {
			temp = curr.getPrevious();
			curr.setPrevious(curr.getNext());
			curr.setNext(temp);
			curr = curr.getPrevious();
		}
		if(temp != null) {
			root = temp.getPrevious();
		}
		return root;
	}
	
	public DoublyNode deleteNode(DoublyNode root, int value) {
		DoublyNode curr = root;
		while(curr != null) {
			if(curr.getValue() == value) {
				if(curr.getPrevious() == null) {
					//If it's first node.
					root = curr.getNext();
				} else if(curr.getNext() == null) {
					//If it's the last node.
					curr.getPrevious().setNext(null);
				} else {
					//If it's neither first nor last node.
					curr.getPrevious().setNext(curr.getNext());
					curr.getNext().setPrevious(curr.getPrevious());
				}
				break;
			} else {
				curr = curr.getNext();
			}
		}
		return root;
	}
	
	public void printList(DoublyNode root) {
		DoublyNode curr = root;
		while(curr != null) {
			System.out.println(curr.getValue());
			curr = curr.getNext();
		}
	}
	
	public static void main(String arg[]) {
		DoublyLinkedListMethods dll = new DoublyLinkedListMethods();
		DoublyNode root = null;
		int i = 1;
		while(i <= 10) {
			root = dll.add(root, i);
			i++;
		}
		//root = dll.reverse(root);
		root = dll.deleteNode(root, 4);
		dll.printList(root);
	}
}
