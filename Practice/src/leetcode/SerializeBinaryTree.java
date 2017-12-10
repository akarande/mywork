package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SerializeBinaryTree {

	class TreeNode {
		int val;
		TreeNode left, right;
		public TreeNode(int x) {val = x;}
	}
	
	List<List<TreeNode>> levelOrder(TreeNode root) {
        List<List<TreeNode>>levelOrdering = new ArrayList<>();
        if(root == null) return levelOrdering;
        List<TreeNode>queue = new ArrayList<>();
        List<TreeNode>temp = new ArrayList<>();
        int i = 0;
        queue.add(root);
        levelOrdering.add(new ArrayList<>(queue));
        while(i < queue.size()) {
            TreeNode curr = queue.get(i++);
            if(curr.left != null) temp.add(curr.left);
            if(curr.right != null) temp.add(curr.right);
            if(i >= queue.size()) {
                queue.addAll(temp);
                levelOrdering.add(new ArrayList<>(temp));
                temp.clear();
            }
        }
        return levelOrdering;
    }
    
    TreeNode addNode(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        if(root == null) root = node;
        else {
            List<TreeNode>queue = new ArrayList<>();
            List<TreeNode>temp = new ArrayList<>();
            queue.add(root);
            int i = 0;
            while(i < queue.size()) {
                TreeNode curr = queue.get(i++);
                if(curr.left == null) {
                    curr.left = node;
                    break;
                } else if(curr.right == null) {
                    curr.right = node;
                    break;
                } else {
                    if(curr.left != null) temp.add(curr.left);
                    if(curr.right != null) temp.add(curr.right);
                }
                if(i > queue.size()) {
                    queue.addAll(temp);
                    temp.clear();
                }
            }
        }
        return root;
    }
    
    TreeNode addBSTNode(TreeNode root, int val) {
    	if(root == null) root = new TreeNode(val);
    	else if(root.val > val) {
    		root.left = addBSTNode(root.left, val);
    	} else {
    		root.right = addBSTNode(root.right, val);
    	}
    	return root;
    }
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<List<TreeNode>> levelOrdering = levelOrder(root);
        StringBuilder sb = new StringBuilder();
        for(List<TreeNode> treeNode : levelOrdering) {
            for(TreeNode node : treeNode) {
                sb.append(node.val+"$");
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String arr[] = data.split("\\$");
        if(arr.length == 0 || arr[0] == null || arr[0].length() == 0) return null;
        TreeNode root = null;
        for(int i = 0; i < arr.length; i++) {
            root = addBSTNode(root, Integer.parseInt(arr[i]));
        }
        return root;
    }
    
    void inorder(TreeNode root) {
    	if(root == null) return;
    	inorder(root.left);
    	System.out.print(root.val + "\t");
    	inorder(root.right);
    }
    
    void printArray(List<List<TreeNode>> root) {
    	for(List<TreeNode> level : root) {
    		for(TreeNode eachNode : level) {
    			System.out.print(eachNode.val + "\t");
    		}
    		System.out.println();
    	}
    }
    
    public static void main(String arg[]) {
    	SerializeBinaryTree sbt = new SerializeBinaryTree();
    	TreeNode root = null;
    	/*root = sbt.addNode(root, 2);
    	root = sbt.addNode(root, 1);
    	root = sbt.addNode(root, 3);
    	sbt.inorder(root);
    	System.out.println();*/
    	sbt.printArray(sbt.levelOrder(root));
    	System.out.println();
    	System.out.println(sbt.serialize(root));
    	System.out.println();
    	root = sbt.deserialize(sbt.serialize(root));
    	sbt.inorder(root);
    }
}
