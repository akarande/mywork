package leetcode;

public class ReverseLinkedListII {

	class ListNode {
		int val;
		ListNode next;
		public ListNode(int x) { val  = x; }
	}
	
	ListNode add(ListNode head, int val) {
		ListNode node = new ListNode(val);
		if(head == null) {
			head = node;
		} else  {
			ListNode curr = head;
			while(curr.next != null) {
				curr = curr.next;
			}
			curr.next = node;
		}
		return head;
	}
	
	public ListNode reverseBetween(ListNode head, int m, int n) {
        int i = 1;
        ListNode curr = head;
        ListNode begin = curr;
        while(curr != null && i < m) {
            begin = curr;
            curr = curr.next;
            i++;
        }
        //Now we reverse the list
        ListNode next = null;
        ListNode prev = null;
        i = m-1;
        while(i <= n && curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i++;
        }
        while(begin.next != null) begin = begin.next;
        begin.next = next;
        return head;
    }
	
	void printList(ListNode head) {
		while(head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
	
	public static void main(String arg[]) {
		ReverseLinkedListII rllII = new ReverseLinkedListII();
		ListNode head = null;
		head = rllII.add(head, 1);
		head = rllII.add(head, 2);
		head = rllII.add(head, 3);
		head = rllII.add(head, 4);
		head = rllII.add(head, 5);
		rllII.printList(head);
		int m = 2, n = 4;
		head = rllII.reverseBetween(head, m, n);
		System.out.println();
		rllII.printList(head);
		
	}
}
