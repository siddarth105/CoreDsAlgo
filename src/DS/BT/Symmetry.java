package DS.BT;

public class Symmetry {

	static TreeNode root;

	static boolean isMirror(TreeNode node1, TreeNode node2) {
		if (node1 == null && node2 == null)
			return true;

		if (node1 != null && node2 != null && node1.data == node2.data)
			return (isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left));

		return false;
	}

	public static void main(String args[]) {
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);
		boolean output = isMirror(root, root);
		if (output == true)
			System.out.println("Given Tree is Symmetric");
		else
			System.out.println("Given Tree is not Symmetric");
	}
	
/*		 1
	   /   \
	  2     2
	 / \   / \
	3   4 4   3  */

}
