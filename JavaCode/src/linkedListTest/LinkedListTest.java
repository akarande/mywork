package linkedlisttest;

import linkedlist.LinkedListImpl;
import linkedlist.Node;

import org.junit.Test;

public class LinkedListTest {

	protected LinkedListImpl ll = new LinkedListImpl();
	protected Node head = new Node(1);
	@Test
	public void test0() {
		ll.add(head, 2);
		ll.add(head, 23);
		ll.add(head, 30);
		ll.add(head, 33);
		ll.add(head, 47);
		ll.add(head, 49);
		ll.printMyList(head);
	}
	
	@Test
	public void test1() {
		test0();
		head = ll.remove(head, new Node(30));
		ll.printMyList(head);
		head = ll.remove(head, new Node(49));
		ll.printMyList(head);
	}

	@Test
	public void test3() {
		test0();
		head = ll.reverse(head);
		ll.printMyList(head);
	}
	
	@Test
	public void test4() {
		test0();
		head = ll.recursiveReverse(head);
		ll.printMyList(head);
	}
}
