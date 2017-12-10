package leetcode;

public class ReorderList {

	class ListNode {
		int val;
		ListNode next;
		public ListNode(int x) { val = x;}
	}
	
	public ListNode add(ListNode head, int val) {
		if(head == null) head = new ListNode(val);
		else {
			ListNode curr = head;
			while(curr.next != null) curr = curr.next;
			curr.next = new ListNode(val);
		}
		return head;
	}
	public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode curr = head;
        ListNode temp = slow;
        printList(slow);
        slow = reverse(slow);
        /*while(slow != null && curr != temp) {
            ListNode t = curr.next;
            curr.next = slow.next;
            slow.next = t;
            curr = curr.next;
            slow = slow.next;
        }*/
        System.out.println();
        printList(slow);
        
        while(curr != temp) {
            ListNode next = curr.next;
            curr.next = slow;
            slow = slow.next;
            curr.next.next = next;
            curr = next;
        }
        curr.next = null;
        System.out.println("\nFinalList\n");
        printList(head);
    }
    
    void printList(ListNode head) {
        while(head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
    
    ListNode reverse(ListNode head) {
        ListNode next = null;
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
    public static void main(String arg[]) {
    	ReorderList rl = new ReorderList();
    	ListNode head = null;
    	head = rl.add(head, 1);
    	head = rl.add(head, 2);
    	head = rl.add(head, 3);
    	/*head = rl.add(head, 4);
    	head = rl.add(head, 5);
    	head = rl.add(head, 6);*/
    	rl.printList(head);
    	System.out.println();
    	rl.reorderList(head);
    }
}
