package DS.BST;


public class Node {
	
	
	int key;
	Node left, right;
	
	public Node() {
	}

	public Node(int item) {
		key = item;
		left = right = null;
	}
	
	static Node insertRec(Node root, int key) {

		if (root == null) {
			root = new Node(key);
			return root;
		}

		if (key < root.key)
			root.left = insertRec(root.left, key);
		else if (key > root.key)
			root.right = insertRec(root.right, key);

		return root;
	}
	
	static void inorderRec(Node nd) {
		if (nd == null)
			return;
		inorderRec(nd.left);
		System.out.print(nd.key + " ");
		inorderRec(nd.right);
		
	}
}
