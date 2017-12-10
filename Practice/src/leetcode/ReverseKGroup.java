package leetcode;

public class ReverseKGroup {

	class ListNode {
		int val;
		ListNode next;
		public ListNode(int x) {val = x;}
	}
	
	public ListNode add(ListNode head, int val) {
		ListNode node = new ListNode(val);
		if(head == null) head = node;
		else {
			ListNode curr = head;
			while(curr.next != null) curr = curr.next;
			curr.next = node;
		}
		return head;
	}
	
	void printAll(ListNode head) {
		while(head != null) {
			System.out.print(head.val + "\t");
			head = head.next;
		}
		System.out.println();
	}
	
	public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 0) return head;
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        ListNode currEnd = head;
        int total = lengthOfList(head) / k;
        int t = k;
        while(total > 0) {
        	t = k;
	        while(curr != null && t > 0) {
	            next = curr.next;
	            curr.next = prev;
	            prev = curr;
	            curr = next;
	            t--;
	        }
	        total--;
        }
        if(curr != null) currEnd.next = curr;
        return prev;
    }
	
	public int lengthOfList(ListNode head) {
		int count = 0;
		while(head != null) {
			count++;
			head = head.next;
		}
		return count;
	}
	
	public static void main(String arg[]) {
		ReverseKGroup rkg = new ReverseKGroup();
		ListNode head = null;
		head = rkg.add(head, 1);
		head = rkg.add(head, 2);
		head = rkg.add(head, 3);
		head = rkg.add(head, 4);
		head = rkg.add(head, 5);
		head = rkg.reverseKGroup(head, 2);
		rkg.printAll(head);
	}
}
