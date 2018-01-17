package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeSerialization {
	
	class TreeNode {
		TreeNode left, right;
		int val;
		public TreeNode(int x) { val = x;}
	}

	public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildTree(root, sb);
        return sb.toString();
    }
    
    void buildTree(TreeNode root, StringBuilder sb) {
        if(root == null) sb.append("Z,");
        else {
            sb.append(String.valueOf(root.val) + ",");
            buildTree(root.left, sb);
            buildTree(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        TreeNode root = null;
        if(data == null) return root;
        Queue<String>arr = new LinkedList<>();
        arr.addAll(Arrays.asList(data.split(",")));
        root = buildTree(arr);
        return root;
    }
    
    TreeNode buildTree(Queue<String> arr) {
        String curr = arr.remove();
        if(curr.equals("Z")) {
            return null;
        } else {
            System.out.println(curr);
            TreeNode node = new TreeNode(Integer.valueOf(curr));
            node.left = buildTree(arr);
            node.right = buildTree(arr);
            return node;
        }
    }
}
