package DS.BT;

public class BST {

	class Node {
	    int key;
	    Node left, right;
	    
	    public Node() {
	        key = 0;
	        left = right = null;
	    }
	 
	    public Node(int item) {
	        key = item;
	        left = right = null;
	    }
	}
	
	Node root;
	static Node prev;
	
	BST(int key) {
        root = new Node(key);
    }
 
	BST() {
        root = null;
    }
	
	boolean isBST() {
		prev = null;
		return isBST(root);
	}
	 
	boolean isBST(Node node) {
		if (node != null) {
			if (!isBST(node.left))
				return false;

			// check for ascending order
			if (prev != null && node.key <= prev.key)
				return false;
			prev = node;
			
			return isBST(node.right);
		}
		
		//BASE_CASE :-
		return true;
	}
	
	static boolean isBinST(Node node) {
		if (null == node) {
			return true;
		}
		boolean lt = isBinST(node.left);
		if (prev != null && node.key <= prev.key)
			return false;
		prev = node;
		boolean rt = isBinST(node.right);
		return lt && rt;
	}
	
	public static void main(String args[]) {
		BST tree = new BST();
		
		tree.root = tree.new Node(4);
		tree.root.left = tree.new Node(2);
		tree.root.right = tree.new Node(5);
		tree.root.left.left = tree.new Node(1);
		tree.root.left.right = tree.new Node(3);
		
		if (isBinST(tree.root))
			System.out.println("IS BST");
		else
			System.out.println("Not a BST");

		if (tree.isBST())
			System.out.println("IS BST");
		else
			System.out.println("Not a BST");
	}
	
}
