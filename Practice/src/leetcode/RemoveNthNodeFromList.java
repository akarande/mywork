package leetcode;

public class RemoveNthNodeFromList {
	
	class ListNode {
		int val;
		ListNode next;
		public ListNode(int x) {val = x;}
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;
        ListNode curr = head;
        ListNode fast = head;
        int i = 0;
        while(i < n) {
            fast = fast.next;
            i++;
        }
        if(fast == null) return head.next;
        fast = fast.next;
        while(fast != null) {
            curr = curr.next;
            fast = fast.next;
        }
        curr.next = curr.next.next;
        return head;
    }
}
