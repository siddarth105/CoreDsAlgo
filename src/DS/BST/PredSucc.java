package DS.BST;

public class PredSucc {
	
	
	static Node root;
	static int pred;
	static int succ;
	static int k;

	static void insert(int key) {
		root = Node.insertRec(root, key);
	}
	
	static void inorder() {
		Node.inorderRec(root);
		System.out.println();
	}
	
	public static void search(Node nd) {
		
		if (null==nd)
			return;
		
		if (nd.key == k) {
			
			if (null != nd.left) {
				Node lt = nd.left;
				while (null != lt.right) {
					lt = lt.right;
				}
				pred = lt.key;
			}
			if (null != nd.right) {
				Node rt = nd.right;
				while (null != rt.left) {
					rt = rt.left;
				}
				succ = rt.key;
			}
			return;
		}
		
		if (k > nd.key) {
			
			pred = nd.key;
			search(nd.right);
			
		} else {
			
			succ = nd.key;
			search(nd.left);
		}
		
		
	}
	
	public static void main(String[] args) {
		
		insert(4);
		insert(2);
		insert(3);
		insert(1);
		insert(7);
		insert(5);
		insert(8);
		
		inorder();
		
		k = 6;
		
		search(root);
		System.out.println("Predessor :: " + pred);
		System.out.println("Successor :: " + succ);
	}
}
