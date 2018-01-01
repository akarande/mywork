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
	
	public ListNode reverseKGroup2(ListNode head, int k) {
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
	
	/**
	 * Actual solution without swapping the values
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null) {
            ListNode begin = curr;	//Keep the beginning so that we know where to start the reversing process
            int i = k;
            while(i > 0 && curr != null) {	//Check if there are at-least k elements to reverse
                curr = curr.next;
                i--;
            }
            if(i == 0) {	//If there are k elements reverse them
                ListNode reversedList = reverse(begin, k);
                if(prev == null) prev = reversedList;	//check if this is the first k elements reversed
                else {	//If not iterate to the end of reversed list and attach the next of current list to the newly reversed list
                    ListNode newList = prev;
                    while(newList.next != null) newList = newList.next;
                    newList.next = reversedList;
                }
            } else {	//There were elements less than k so we did not reverse them
                if(prev != null) {	//Check if these were starting elements, if not iterate till the end and then append the un-reversed elements since the remaining elements didn't reach to size k
                    ListNode newList = prev;
                    while(newList.next != null) {
                        newList = newList.next;
                    }
                    newList.next = begin;
                } else {	//actual list was smaller than the given k, just return the original list
                    return head;
                }
            }
        }
        head = prev;
        return head;
    }
    
    ListNode reverse(ListNode root, int count) {
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = root;
        while(count > 0 && curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count--;
        }
        return prev;
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
