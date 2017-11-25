package leetcode;

public class ReverseLinkedList {
	
	class ListNode {
		int val;
		ListNode next;
		
		public ListNode(int x) {val = x;}
	}
	
	ListNode add(ListNode head, int val) {
		ListNode node = new ListNode(val);
		if(head == null) {
			head = node;
		} else {
			ListNode curr = head;
			while(curr.next != null) {
				curr = curr.next;
			}
			curr.next = node;
		}
		return head;
	}
	
	public ListNode reverse(ListNode head) {
		if(head == null || head.next == null) return head;
		ListNode prev = null;
		ListNode next = null;
		ListNode curr = head;
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
	
	
	/**
	 * 1. Divide the list in 2 parts - first node and rest of the list.
	 * 2. Recursively call reverse for the rest of the linked list.
	 * 3. Link rest to first.
	 * 4. Fix head pointer
	 * Link: http://www.geeksforgeeks.org/wp-content/uploads/2009/07/Linked-List-Rverse.gif
	 */
	public ListNode reverseRecursive(ListNode head) {
		if(head == null || head.next == null) return head;
		ListNode rest = reverseRecursive(head.next);
		head.next.next = head;
		head.next = null;
		return rest;
	}
	
	void printNodes(ListNode head) {
		while(head != null) {
			System.out.print(head.val + "\t");
			head = head.next;
		}
	}
	
	
	public static void main(String arg[]) {
		ReverseLinkedList rll = new ReverseLinkedList();
		ListNode head = null;
		head = rll.add(head, 1);
		head = rll.add(head, 2);
		head = rll.add(head, 3);
		head = rll.add(head, 4);
		head = rll.add(head, 5);
		head = rll.add(head, 6);
		head = rll.reverseRecursive(head);
		rll.printNodes(head);
	}

}
