package leetcode;

public class MinStack {

	class ListNode {
        int val, min;
        ListNode next;
        public ListNode(int val, int min, ListNode prev) {
            this.val = val;
            this.min = min;
            this.next = prev;
        }
    }
    /** initialize your data structure here. */
    private ListNode head;
    public MinStack() {
        head = null;
    }
    
    public void push(int x) {
        if(head == null) {
            head = new ListNode(x, x, null);
        } else {
            head = new ListNode(x, Math.min(x, head.min), head);
        }
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
    
    public static void main(String arg[]) {
    	
    }
}
