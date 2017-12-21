package DS.BT;

public class BT2DLL {

	static TreeNode root;
	static TreeNode head;
	static TreeNode prev;

	public static void inOrder(TreeNode nd) {

		if (nd == null)
			return;

		inOrder(nd.left);
		System.out.print(nd.data + " ");
		inOrder(nd.right);

	}
	
	public static void btToDLL(TreeNode nd) {

		if (nd == null)
			return;

		btToDLL(nd.left);
		
		if (prev != null) {
			prev.right = nd;
			nd.left = prev;
		} else {
			head = nd;
		}
		prev = nd;
		
		btToDLL(nd.right);

	}
	
	public static void printLst() {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.right;
		}
	}

	public static void main(String[] args) {

		root = new TreeNode(1);

		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		root.left.right.left = new TreeNode(6);
		root.left.right.right = new TreeNode(7);
		
		inOrder(root);
		btToDLL(root);
		System.out.println();
		printLst();
	}
}
