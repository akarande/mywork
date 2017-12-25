package leetcode;

import java.util.Random;

public class RandomListNode {

	class ListNode {
		ListNode next;
		int val;
		
		public ListNode(int x) {
			val = x;
		}
	}
	
	ListNode head;
    Random random;
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public RandomListNode(ListNode h) {
        head = h;
        random = new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        if(head == null) return 0;
        ListNode curr = head;
        int prev = curr.val;
        for(int i = 1; curr.next != null; i++) {
            curr = curr.next;
            int randomNumber = random.nextInt(i+1);
            if(i == randomNumber) prev = curr.val;
        }
        return prev;
    }
}
