package general;

public class AVLTree {
	
	class TreeNode {
		int val;
		TreeNode left, right;
		int height;
		
		public TreeNode(int x) { val = x; }
	}

	//Regular Insert
	public TreeNode insert(TreeNode root, int val) {
		TreeNode node = new TreeNode(val);
		if(root == null) root = node;
		else {
			if(root.val < val) {
				root.right = insert(root.right, val);
			} else {
				root.left = insert(root.left, val);
			}
		}
		return root;
	}
	
	public int height(TreeNode root) {
		if(root == null) return 0;
		return 1 + Math.max(height(root.left), height(root.right));
	}
	
	TreeNode rightRotate(TreeNode root) {
		TreeNode newRoot = root.left;
		root.left = newRoot.right;
		newRoot.right = root;
		root.height = 1 + Math.max(root.left.height, root.right.height);
		newRoot.height = 1 + Math.max(newRoot.left.height, newRoot.right.height);
		return newRoot;
	}
	
	TreeNode leftRotate(TreeNode root) {
		TreeNode newRoot = root.right;
		root.right = newRoot.left;
		newRoot.left = root;
		root.height = 1 + Math.max(root.left.height, root.right.height);
		newRoot.height = 1 + Math.max(root.left.height, root.right.height);
		return newRoot;
	}
	
	//AVL Insert
	public TreeNode insertAVL(TreeNode root, int val) {
		TreeNode node = new TreeNode(val);
		if(root == null) root = node;
		else  {
			if(root.val < val) {
				root.right = insertAVL(root.right, val);
			} else {
				root.left = insertAVL(root.left, val);
			}
		}
		int balance = root.left.height - root.right.height;
		if(balance > 1) {
			if(root.left.left.height >= root.left.right.height) { //LL Case
				root = rightRotate(root);
			} else {	//LR Case
				root.left = leftRotate(root.left);
				return rightRotate(root);
			}
		} else if(balance < -1) {
				if(root.right.right.height >= root.right.left.height) { //RR Case
					return leftRotate(root);
				} else {	//RL Case
					root.right = rightRotate(root.right);
					return leftRotate(root);
				}
		} else {
			root.height = 1 + Math.max(root.left.height, root.right.height);
		}
		return root;
	}
	
	void inorder(TreeNode root) {
		if(root == null) return;
		inorder(root.left);
		System.out.print(root.val + ", ");
		inorder(root.right);
	}
	
	void preorder(TreeNode root) {
		if(root == null) return;
		System.out.print(root.val + ", ");
		preorder(root.left);
		preorder(root.right);
	}
	
	public static void main(String args[]){
        AVLTree avlTree = new AVLTree();
        TreeNode root = null;
        root = avlTree.insert(root, -10);
        root = avlTree.insert(root, 2);
        root = avlTree.insert(root, 13);
        root = avlTree.insert(root, -13);
        root = avlTree.insert(root, -15);
        root = avlTree.insert(root, 15);
        root = avlTree.insert(root, 17);
        root = avlTree.insert(root, 20);
        
        avlTree.inorder(root);
        System.out.println();
        avlTree.preorder(root);
    }
}
