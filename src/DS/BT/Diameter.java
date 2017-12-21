package DS.BT;

import DS.BT.BinaryTree.Node;

public class Diameter {
	
	
	 static class Height {
		int height;
	}
	
	/*	TIME_COMPLEXITY :: O(n^2)	*/
	static int diameter(Node nd) {
		
		if (nd == null)
			return 0;

		int lheight = height(nd.left);
		int rheight = height(nd.right);

		int ldiameter = diameter(nd.left);
		int rdiameter = diameter(nd.right);

		return Math.max(lheight + rheight + 1, Math.max(ldiameter, rdiameter));
	}
	
	/*	TIME_COMPLEXITY :: O(n)	*/
	static int diameter(Node nd, Height ht) {
		
		Height lht = new Height(); 
		Height rht = new Height();
		
		if (nd == null){
			ht.height = 0;
			return 0;
		}
		
		lht.height ++; rht.height ++;
		int ldiameter = diameter(nd.left, lht);
		int rdiameter = diameter(nd.right, rht);
		
		ht.height = Math.max(lht.height, rht.height) + 1;
		
		return Math.max(lht.height + rht.height + 1, Math.max(ldiameter, rdiameter));
	}
	
	public static int height(Node root) {
        if (root == null) {
           return 0;
        } else {
            int lheight = height(root.left);
            int rheight = height(root.right);
             
            if (lheight > rheight)
                return(lheight+1);
            else 
            	return(rheight+1); 
        }
    }
	
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		 
		tree.root = tree.new Node(1);

		tree.root.left = tree.new Node(2);
		tree.root.right = tree.new Node(3);

		tree.root.left.left = tree.new Node(4);
		tree.root.left.right = tree.new Node(5);
	
		tree.root.left.right.left = tree.new Node(6);
		tree.root.left.right.right = tree.new Node(7);
		
		
		 System.out.println("The diameter of given binary tree is : "
                 + diameter(tree.root) + "	-> TIME_COMPLEXITY :: O(n^2)");
		 System.out.println("The diameter of given binary tree is : "
                 + diameter(tree.root, new Height()) + "	-> TIME_COMPLEXITY :: O(n)");
	}

}
