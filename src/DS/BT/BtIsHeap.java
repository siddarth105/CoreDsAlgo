package DS.BT;

//Check if the given Bonary Tree is a Max Heap or NOT
public class BtIsHeap {
	
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
 
    BtIsHeap(int key) {
        root = new Node(key);
    }
 
    BtIsHeap() {
        root = null;
    }
    
	static int countNodes(Node nd) {
		if (null == nd)
			return 0;
		return 1 + countNodes(nd.left) + countNodes(nd.right);
	}
    
	static boolean isCompleteUtil(Node nd, int index, int number_nodes) {
		// An empty tree is complete
		if (nd == null)
			return true;

		// If index assigned to current node is more than number of nodes in tree, then tree is not complete
		if (index >= number_nodes)
			return false;

		// Recur for left and right subtrees
		return isCompleteUtil(nd.left, 2 * index + 1, number_nodes)
				&& isCompleteUtil(nd.right, 2 * index + 2, number_nodes);
	}
	
	
	static boolean isHeapUtil(Node nd) {
		// Base case : single node satisfies property
		if (nd.left == null && nd.right == null)
			return true;

		if (nd.right == null) {
			return (nd.key >= nd.left.key);
		} else {
			if (nd.key >= nd.left.key && nd.key >= nd.right.key)
				return (isHeapUtil(nd.left) && isHeapUtil(nd.right));
			else
				return false;
		}
	}
	
	static boolean isHeap(Node root) {
		int node_count = countNodes(root);
		int index = 0;

		if (isCompleteUtil(root, index, node_count) && isHeapUtil(root))
			return true;
		return false;
	}
	
    public static void main(String[] args) {
    	BtIsHeap tree = new BtIsHeap();
    	tree.root = tree.new Node(10);
    	tree.root.left = tree.new Node(9);
        tree.root.right = tree.new Node(8);
        tree.root.left.left = tree.new Node(7);
        tree.root.left.right = tree.new Node(6);
        tree.root.right.left = tree.new Node(5);
        tree.root.right.right = tree.new Node(4);
        tree.root.left.left.left = tree.new Node(3);
        tree.root.left.left.right = tree.new Node(2);
        tree.root.left.right.left = tree.new Node(1);
        
        if (isHeap(tree.root))
        	System.out.println("Is a Max-Heap");
        else
        	System.out.println("Is NOT a Max-Heap");
        
    }

}
