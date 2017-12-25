package leetcode;

public class RotateLinkedList {
	
	class ListNode {
		int val;
		ListNode next;
		public ListNode(int x) { val = x;}
	}

	public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        ListNode curr = head;
        int n = 1; //Count the length of LinkedList
        while(curr.next != null) {
            curr = curr.next;
            n++;
        }
        
        curr.next = head;   //Make it a circular LinkedList
        k = k % n;  //Get the k%n value that is the number of rotation we need to perform
        int i = 0;
        while(i < n-k) {    //Only go upto the point from where we need to start the rotation
            curr = curr.next;
            i++;
        }
        ListNode newHead = curr.next;
        curr.next = null;
        return newHead;
    }
	
	ListNode add(ListNode head, int value) {
		ListNode newNode = new ListNode(value);
		if(head == null) head = newNode;
		else {
			ListNode curr = head;
			while(curr.next != null) {
				curr = curr.next;
			}
			curr.next = newNode;
		}
		return head;
	}
	
	void printList(ListNode head) {
		while(head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
	
	public static void main(String arg[]) {
		RotateLinkedList rll = new RotateLinkedList();
		ListNode head = rll.add(null, 1);
		head = rll.add(head, 2);
		head = rll.add(head, 3);
		head = rll.add(head, 4);
		head = rll.add(head, 5);
		head = rll.add(head, 6);
		//rll.printList(head);
		int k = 2;
		ListNode newHead = rll.rotateRight(head, k);
		rll.printList(newHead);
	}
}
