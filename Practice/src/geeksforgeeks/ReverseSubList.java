package geeksforgeeks;

/**
 * Input : 10->20->30->40->50->60->70->NULL
 *      m = 3, n = 6
 * Output : 10->20->60->50->40->30->70->NULL
 *
 * Input :  1->2->3->4->5->6->NULL 
 *        m = 2, n = 4
 * Output : 1->4->3->2->5->6->NULL
 * @author akarande
 *
 */

public class ReverseSubList {

	class Node {
		int value;
		Node next;
		Node(int value) {
			this.value = value;
			this.next = null;
		}
	}
	
	public Node add(Node head, int value) {
		if(head == null) {
			head = new Node(value);
		} else {
			Node curr = head;
			while(curr.next != null) {
				curr = curr.next;
			}
			curr.next = new Node(value);
		}
		return head;
	}
	
	public Node solve(Node head, int m, int n) {
		int i = 0, j = 0;
		int arr[] = new int[n-m+1];
		Node curr = head;
		Node begin = null;
		if(curr == null) {
			return null;
		} else {
			while(i < m && curr != null) {
				begin = curr;
				curr = curr.next;
				i++;
			}
			i = i-1;
			curr = begin;
			while(curr != null && j < arr.length) {
				arr[j] = curr.value;
				curr = curr.next;
				j++;
			}
			j = arr.length-1;
			curr = begin;
			while(curr != null && j >= 0) {
				curr.value = arr[j];
				j--;
				curr = curr.next;
			}
		}
		return head;
	}
	
	public void printList(Node head) {
		Node curr = head;
		while(curr != null) {
			System.out.println(curr.value);
			curr = curr.next;
		}
	}
	
	public static void main(String arg[]) {
		ReverseSubList rsl = new ReverseSubList();
		Node head = null; 
		head = rsl.add(head, 10);
		head = rsl.add(head, 20);
		head = rsl.add(head, 30);
		head = rsl.add(head, 40);
		head = rsl.add(head, 50);
		head = rsl.add(head, 60);
		head = rsl.add(head, 70);
		int m = 2, n = 4;
		head = rsl.solve(head, m, n);
		rsl.printList(head);
	}
}
