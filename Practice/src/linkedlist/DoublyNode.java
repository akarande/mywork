package linkedlist;

public class DoublyNode {

	private int value;
	private DoublyNode previous;
	private DoublyNode next;
	
	public DoublyNode(int value) {
		this.value = value;
		this.previous = null;
		this.next = null;
	}
	
	public DoublyNode getPrevious() {
		return previous;
	}

	public void setPrevious(DoublyNode previous) {
		this.previous = previous;
	}

	public DoublyNode getNext() {
		return next;
	}

	public void setNext(DoublyNode next) {
		this.next = next;
	}

	public int getValue() {
		return value;
	}
}
