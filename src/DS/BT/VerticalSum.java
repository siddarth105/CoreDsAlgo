package DS.BT;

import java.util.HashMap;

public class VerticalSum {
	
	private TreeNode root;
	  
    // Constructors
    public VerticalSum() { 
    	root = null; 
    }
    
    public VerticalSum(TreeNode n) { 
    	root = n; 
    }
  
    // Method to be called by the consumer classes like Main class
    public void VerticalSumMain() { 
    	VerticalSum(root); 
    }
  
    // A wrapper over VerticalSumUtil()
    private void VerticalSum(TreeNode root) {
  
        // base case
        if (root == null) { return; }
  
        // Creates an empty hashMap hM
        HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();
  
        // Calls the VerticalSumUtil() to store the vertical sum values in hM
        VerticalSumUtil(root, 0, hM);
  
        // Prints the values stored by VerticalSumUtil()
        if (hM != null) {
            System.out.println(hM.entrySet());
        }
    }
  
    // Traverses the tree in Inorder form and builds a hashMap hM that
    // contains the vertical sum
    private void VerticalSumUtil(TreeNode root, int hD, HashMap<Integer, Integer> hM) {
        // base case
        if (root == null) {  return; }
  
        // Store the values in hM for left subtree
        VerticalSumUtil(root.left, hD - 1, hM);
  
        // Update vertical sum for hD of this node
        int prevSum = (hM.get(hD) == null) ? 0 : hM.get(hD);
        hM.put(hD, prevSum + root.data);
  
        // Store the values in hM for right subtree
        VerticalSumUtil(root.right, hD + 1, hM);
    }
    
    public static void main (String[] args) {
    	TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(9);
		root.left.right = new TreeNode(6);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		root.right.left.left = new TreeNode(12);
		root.right.left.right = new TreeNode(7);
		root.left.right.left = new TreeNode(11);
		root.left.left.right = new TreeNode(10);
		VerticalSum tree = new VerticalSum(root);
		tree.VerticalSum(root);
    }
    
    
    /*
    
    Assign Horizontal Distance "hd" for each node, by creating a variable hd in the node class
    Initialise hd = 0 for root and add root to queue
    In_order Traversal
    While in In_order Traversal, check if the hd is present in map
    if present add the current node's value to the sum
    else put it into map
    
    
		       1 :0
		    /       \
	-1:	   2          3    :+1
		 /   \       
-2:		4     5:0  
		    /   \
		-1:6     7:+1
      
    */
}
