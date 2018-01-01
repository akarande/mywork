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
        if(head == null || head.next == null || m == n) return head;
        int i = 1;
        ListNode curr = head;
        ListNode begin = null;
        //Note the condition < is better because you are one node before the actual node to be reversed i.e. curr will be the next node to be reversed.
        while(curr != null && i < m) {
            begin = curr;
            curr = curr.next;
            i++;
        }
        //Now we reverse the list
        ListNode next = null;
        ListNode prev = null;
        i = m-1;
        while(i < n && curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i++;
        }
        //If begin is null it means that the list is reversed from the first element and has no previous elements
        if(begin != null) begin.next = prev;
        else head = prev;
        //We need to append the elements in the end that are not reversed and since previous is the new head we need to traverse through previous till we hit end of the list.
        while(prev.next != null) prev = prev.next;
        prev.next = curr;
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
