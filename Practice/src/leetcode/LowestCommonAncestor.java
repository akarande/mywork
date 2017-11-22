package leetcode;

public class LowestCommonAncestor {
	
	class TreeNode {
		int val;
		TreeNode left, right;
		public TreeNode(int x) {val = x;}
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        } else {
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if(left != null && right != null) {
                return root;
            } else {
                return left == null ? right : left;
            }
        }
    }
	
	public static void main(String arg[]) {
		LowestCommonAncestor lca = new LowestCommonAncestor();
		//lca.lowestCommonAncestor(root, p, q);
	}
}
