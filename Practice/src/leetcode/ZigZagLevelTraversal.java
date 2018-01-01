package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ZigZagLevelTraversal {
	
	class TreeNode { 
		TreeNode left, right;
		int val;
		public TreeNode(int x) {val = x;}
	}
	
	TreeNode add(TreeNode root, int value) {
		TreeNode newNode = new TreeNode(value);
		if(root == null) root = newNode;
		List<TreeNode>temp = new ArrayList<>();
		List<TreeNode>queue = new ArrayList<>();
		int i = 0;
		while(i < queue.size()) {
			TreeNode curr = queue.get(i++);
			if(curr.left == null) {
				curr.left = newNode;
				break;
			} else if(curr.right == null) {
				curr.right = newNode;
				break;
			} else {
				if(curr.left != null) temp.add(curr.left);
				if(curr.right != null) temp.add(curr.right);
			}
			if(i >= queue.size()) {
				queue.addAll(temp);
				temp.clear();
			}
		}
		return root;
	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>result = new ArrayList<>();
        List<TreeNode>queue = new ArrayList<>();
        List<TreeNode>temp = new ArrayList<>();
        if(root == null) return result;
        queue.add(root);
        int i = 0;
        int level = 0;
        List<Integer>lst = new ArrayList<>();
        while(i < queue.size()) {
            TreeNode curr = queue.get(i++);
            lst.add(curr.val);
            if(curr.left != null) temp.add(curr.left);
            if(curr.right != null) temp.add(curr.right);
            if(i >= queue.size()) {
                if(level%2 == 0) {
                    result.add(new ArrayList<>(lst));
                } else {
                    Collections.reverse(lst);
                    result.add(new ArrayList<>(lst));
                }
                lst.clear();
                level++;
                queue.addAll(temp);
                temp.clear();
            }
        }
        return result;
    }
	
	public static void main(String arg[]) {
		ZigZagLevelTraversal zzt = new ZigZagLevelTraversal();
		TreeNode root = null;
		root = zzt.add(root, 3);
		root = zzt.add(root, 9);
		root = zzt.add(root, 15);
		root = zzt.add(root, 20);
		root = zzt.add(root, 7);
		for(List<Integer> lst: zzt.zigzagLevelOrder(root)) {
			System.out.println(lst.toString());
		}
	}
}
