package leetcode;

import java.util.PriorityQueue;

public class MergeKLists {
	
	public class ListNode {
		int val;
		ListNode next;
		public ListNode(int x) {val = x;}
	}

	public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        return solve(lists);
    }
    
    ListNode solve(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        //Define a priority queue with the comparator rules
        PriorityQueue<ListNode>queue = new PriorityQueue<>(lists.length, (e1, e2) -> (e1.val - e2.val));
        
        //Add each element to the queue
        for(ListNode n : lists) {
            if(n != null) queue.add(n);
        }
        
        //Adding a dummy node
        ListNode result = new ListNode(0);
        ListNode newHead = result;
        //Now remove the elements from the queue and form the single linkedlist
        while(!queue.isEmpty()) {
            result.next = queue.poll();
            result = result.next;
            //Add this if the current list has a smaller element then next elements in all other lists
            if(result.next != null) queue.add(result.next);
        }
        //Return dummy.next which is the actual head
        return newHead.next;
    }
    
    //Alternate approach
    public ListNode mergeKLists2(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        int n = lists.length;
        return partition(lists, 0, n-1);
    }
    
    ListNode partition(ListNode[] list, int st, int end) {
        if(st == end) return list[st];
        if(st < end) {
            int mid = st + (end - st) / 2;
            ListNode left= partition(list, st, mid);
            ListNode right = partition(list, mid+1, end);
            return merge(left, right);
        } else {
            return null;
        }
        
    }
    
    ListNode merge(ListNode left, ListNode right) {
        if(left == null) return right;
        if(right == null) return left;
        if(left.val < right.val) {
            left.next = merge(left.next, right);
            return left;
        }
        else {
            right.next = merge(left, right.next);
            return right;
        }
    }
}
