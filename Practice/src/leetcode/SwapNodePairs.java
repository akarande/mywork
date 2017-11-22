package leetcode;

public class SwapNodePairs {

	class ListNode {
		int val;
		ListNode next;
		
		public ListNode(int x) { val = x;}
	}
	
	ListNode addNode(ListNode head, int val) {
		ListNode newNode = new ListNode(val);
		if(head == null) head = newNode;
		else {
			ListNode curr = head;
			while(curr.next != null)  curr = curr.next;
			curr.next = newNode;
		}
		return head;
	}
	
	void printNodes(ListNode root) {
		while(root != null) {
			System.out.print(root.val + "\t");
			root = root.next;
		}
		System.out.println();
	}
	
	public ListNode swapNodes(ListNode head) {
		if(head == null || head.next == null) return head;
		ListNode current = head;
		ListNode nextPair = head.next.next;	//Store next starting pair head.
		head = head.next;
		head.next = current;
		current.next = swapNodes(nextPair);
		return head;
	}
	
	public static void main(String arg[]) {
		SwapNodePairs snp = new SwapNodePairs();
		ListNode root = null;
		root = snp.addNode(root, 1);
		root = snp.addNode(root, 2);
		root = snp.addNode(root, 3);
		root = snp.addNode(root, 4);
		root = snp.addNode(root, 5);
		System.out.println("BEFORE");
		snp.printNodes(root);
		System.out.println("AFTER");
		root = snp.swapNodes(root);
		snp.printNodes(root);
	}
}
