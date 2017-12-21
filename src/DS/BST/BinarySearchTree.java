package DS.BST;

class BinarySearchTree {

	class Node {
		int key;
		Node left, right;

		public Node(int item) {
			key = item;
			left = right = null;
		}
	}

	static Node root;

	void insert(int key) {
		root = insertRec(root, key);
	}

	Node insertRec(Node root, int key) {

		if (root == null) {
			root = new Node(key);
			return root;
		}

		if (key < root.key)
			root.left = insertRec(root.left, key);
		else if (key > root.key)
			root.right = insertRec(root.right, key);

		/* return the (unchanged) node pointer */
		return root;
	}

	// A utility function to do inorder traversal of BST -> Backtracking
	static void inorder(Node nd) {
		if (nd == null)
			return;
		inorder(nd.left);
		System.out.print(nd.key + " ");
		inorder(nd.right);
		
	}

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();

		/*
		 * Let us create following BST 
		 * 			50 
		 * 			/ \ 
		 * 		  30   70 
		 * 		 / \   / \ 
		 *      20 40 60  80
		 */
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		inorder(root);
	}
}



/*Binary Search DiagonalSum:-
Binary Search DiagonalSum, is a node-based binary tree data structure which has the following properties:
The left subtree of a node contains only nodes with keys less than the node’s key.
The right subtree of a node contains only nodes with keys greater than the node’s key.
The left and right subtree each must also be a binary search tree.
There must be no duplicate nodes.

         8
      /		\
     3		 10
    / \		   \
   1   6		14
  / \			/
 4   7	       13
 
*/