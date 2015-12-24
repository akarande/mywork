package linkedlist;

public class Node {
	
	private int data;
	private Node next;
	
	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNext() {
		return this.next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node(int data, Node last) {
		this.data = data;
		this.next = last;
	}
	
	public Node(int data) {
		this.data = data;
		this.next = null;
	}
	
}
