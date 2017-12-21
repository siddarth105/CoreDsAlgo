package DS.BT;

public class MaxDiff {

	TreeNode root;

	int maxDiffUtil(TreeNode t, Res res) {
		// Returning Maximum int value if node is not there (one child case)
		if (t == null)
			return Integer.MAX_VALUE;

		// If leaf node then just return node's value
		if (t.left == null && t.right == null)
			return t.data;

		// Recursively calling left and right subtree for minimum value
		int val = Math.min(maxDiffUtil(t.left, res), maxDiffUtil(t.right, res));

		// Updating res if (node value - minimum value from subtree) is bigger than res
		res.r = Math.max(res.r, t.data - val);

		// Returning minimum value got so far
		return Math.min(val, t.data);
	}

	int maxDiff(TreeNode root) {
		Res res = new Res();
		maxDiffUtil(root, res);
		return res.r;
	}

	void inorder(TreeNode root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.data + "");
			inorder(root.right);
		}
	}

	public static void main(String[] args) {
		MaxDiff tree = new MaxDiff();

		tree.root = new TreeNode(8);
		tree.root.left = new TreeNode(3);
		tree.root.left.left = new TreeNode(1);
		tree.root.left.right = new TreeNode(6);
		tree.root.left.right.left = new TreeNode(4);
		tree.root.left.right.right = new TreeNode(7);

		tree.root.right = new TreeNode(10);
		tree.root.right.right = new TreeNode(14);
		tree.root.right.right.left = new TreeNode(13);

		System.out.println("Maximum difference between a node and its ancestor is : " + tree.maxDiff(tree.root));
	}

}
