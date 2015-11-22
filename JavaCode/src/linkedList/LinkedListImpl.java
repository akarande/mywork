package linkedList;

public class LinkedListImpl implements LinkedList {

	@Override
	public Node add(Node head, int value) {
		Node node = new Node(value);
		if(head == null) {
			head  = node;
			head.setNext(null);
		} else {
			Node temp = head;
			while(temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(node);
		}
		return head;
	}

	@Override
	public Node addBefore(Node head, int value, int beforeValue) {
		Node node = new Node(value);
		Node temp = head;
		try {
			while(temp.getNext().getData() != beforeValue) {
				temp = temp.getNext();
			}
			node.setNext(temp.getNext());
			temp.setNext(node);
		} catch(Exception e) {
			System.out.println("Exception while adding a node before position: " + beforeValue);
			throw e;
		}
		return head;
	}

	@Override
	public Node remove(Node head, Node node) {
		Node temp = head;
		if(head.getData() == node.getData()) {//First node
			head = head.getNext();
		} else {//Rest of the nodes
			while(temp.getNext().getData() != node.getData()) {
				temp = temp.getNext();
			}
			if(temp != null) {
				temp.setNext(temp.getNext().getNext());
			}
		}
		return head;
	}

	@Override
	public Node removeAtPosition(Node head, int position)
			throws IndexOutOfBoundsException {
		Node temp = head, prev = null;
		int count = 0;
		while(count < position) {
			prev = temp;
			temp = temp.getNext();
			count++;
		}
		if(temp != null) {
			prev.setNext(temp.getNext());
		}
		return head;
	}

	@Override
	public Node addFirst(Node head, int value) {
		Node node = new Node(value);
		node.setNext(head);
		return node;
	}

	@Override
	public Node reverse(Node head) {
		if(head.getNext() == null) {
			return head;
		} else {
			Node temp = head, prev = null, current = null;
			while(temp != null) {
				current = temp;
				temp = temp.getNext();
				current.setNext(prev);
				prev = current;
			}
			head = prev;
			return head;
		}
	}

	@Override
	public Node recursiveReverse(Node head) {
		if(head == null || head.getNext() == null) {
			return head;
		} else {
			Node rest = recursiveReverse(head.getNext());
			head.getNext().setNext(head);
			head.setNext(null);
			return rest;
		}
	}

	@Override
	public int peek(Node head) {
		return head.getData();
	}

	@Override
	public Node getNodeAtPosition(Node head, int position)
			throws IndexOutOfBoundsException {
		Node temp = head;
		int count = 0;
		while(count < position) {
			temp = temp.getNext();
			count++;
		}
		if(temp != null) {
			return temp;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	public void printMyList(Node head) {
		System.out.println("******************************");
		System.out.println("PRINTING MY LIST BELOW");
		while(head != null) {
		System.out.println("DATA: " + head.getData());
		head = head.getNext();
		}
		System.out.println("******************************");
		System.out.println("\n");
	}
	
}
