package DS.BT;

public class SpiralPrinting {
	
	class Node {
	    int data;
	    Node left, right;
	 
	    public Node(int d) 
	    {
	        data = d;
	        left = right = null;
	    }
	}
 
    Node root;
 
    // Function to print the spiral traversal of tree
    void printSpiral(Node node) {
        int h = height(node);
        int i;
 
        /* ltr -> left to right. If this variable is set then the
           given label is transversed from left to right */
        boolean ltr = false;
        for (i = 1; i <= h; i++) 
        {
            printGivenLevel(node, i, ltr);
            ltr = !ltr;
        }
    }
 
    public int height(Node node) {
        if (node == null) {
            return 0;
        } else {
             
            int lheight = height(node.left);
            int rheight = height(node.right);
 
            if (lheight > rheight) 
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }
 
    /* Print nodes at a given level */
    public void printGivenLevel(Node node, int level, boolean ltr) 
    {
        if (node == null) 
            return;
        if (level == 1) 
            System.out.print(node.data + " ");
        else if (level > 1) {
            if (ltr != false) {
                printGivenLevel(node.left, level - 1, ltr);
                printGivenLevel(node.right, level - 1, ltr);
            }  else {
                printGivenLevel(node.right, level - 1, ltr);
                printGivenLevel(node.left, level - 1, ltr);
            }
        }
    }
    
    
    public static void main(String[] args) {
    	
        SpiralPrinting tree = new SpiralPrinting();
        
        tree.root = tree.new Node(1);
        tree.root.left = tree.new Node(2);
        tree.root.right = tree.new Node(3);
        tree.root.left.left = tree.new Node(4);
        tree.root.left.right = tree.new Node(5);
        tree.root.left.right.left = tree.new Node(6);
        tree.root.left.right.right = tree.new Node(7);
        
        /*
			       1
			    /     \
			   2        3
			 /   \   
			4     5  
			    /   \
			   6     7
			   
         */
        
        System.out.println("Spiral order traversal of Binary Tree is ");
        tree.printSpiral(tree.root);
    }
}