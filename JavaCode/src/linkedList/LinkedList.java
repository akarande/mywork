package linkedlist;

public interface LinkedList {

	Node add(Node head, int value);
	Node addBefore(Node head, int value, int beforeValue);
	Node remove(Node head, Node node);
	Node removeAtPosition(Node head, int position) throws IndexOutOfBoundsException;
	Node addFirst(Node head, int value);
	Node reverse(Node head);
	Node recursiveReverse(Node head);
	int peek(Node head);
	Node getNodeAtPosition(Node head, int position) throws IndexOutOfBoundsException;
	Node sort(Node head);
	int length(Node head);
	
}
