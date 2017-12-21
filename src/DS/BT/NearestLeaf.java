package DS.BT;
/*
 * Given the root and a node X in a tree, find the nearest leaf to X
 */
public class NearestLeaf {
	
	public static Integer travEltNode (TreeNode eltNode, int lvl, Integer minDist) {
		
		TreeNode leafNd = null;
		
		//BASE_CONDITION
		if (eltNode.left == null && eltNode.right == null) {
			//leaf is reached
			if (lvl < minDist) {
				minDist = lvl;
				leafNd = eltNode;
			}
		} else {
			
			//RECURSION
			minDist = travEltNode(eltNode.left, lvl + 1, minDist);
			minDist = travEltNode(eltNode.right, lvl + 1, minDist);
		}
		
		if (null != leafNd) {
			System.out.println("Leaf Node -> " + leafNd.data);
			System.out.println("Min Distance -> " + minDist);
		}
		
		return minDist;
	}
	
	public static Integer thrParent (TreeNode root, TreeNode eltNode, Integer minDist) {
		
		if (null == root) 
			return -1;
		if(root == eltNode) 
			return 0;
		
		// Search eltNode in left subtree of root
		int lft = thrParent (root.left, eltNode,  minDist);
		
		// If left subtree has eltNode
	    if (lft != -1)
	    {
	        // Find closest leaf in right subtree
	    	lft = travEltNode(root.right, lft+2, minDist);
	        return lft ;
	    }
	    
	    
	    // Search eltNode in right subtree of root
	    int rgt = thrParent(root.right, eltNode, minDist);
	    
	    // If right subtree has eltNode
	    if (rgt != -1)
	    {
	        // Find closest leaf in left subtree
	    	rgt = travEltNode(root.left, rgt+2, minDist);
	        return rgt ;
	    }
	 
	    return -1;
	}
	
	public static int getNearLeaf(TreeNode root, TreeNode eltNode) {
		
		int minDist = travEltNode(eltNode, 0, 50000);
		minDist = thrParent(root, eltNode, minDist);
		return minDist;
	}
	
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(10);
		
		/*root.left = new TreeNode(12);
		root.right = new TreeNode(13);
		
		root.right.left = new TreeNode(14);
		root.right.right = new TreeNode(15);
		
		root.right.left.left = new TreeNode(21);
		root.right.left.right = new TreeNode(22);
		
		root.right.right.left = new TreeNode(23);
		root.right.right.right = new TreeNode(24);
		
		root.right.left.left.left = new TreeNode(1);
		root.right.left.left.right = new TreeNode(2);
		
		root.right.left.right.left = new TreeNode(3);
		root.right.left.right.right = new TreeNode(4);
		
		root.right.right.left.left = new TreeNode(5);
		root.right.right.left.right = new TreeNode(6);
		
		root.right.right.right.left = new TreeNode(7);
		root.right.right.right.right = new TreeNode(8);*/
		
		
		root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);
		
		
		Integer shtDist = getNearLeaf(root, root.left);
		System.out.println("Shortest Distance -> " + shtDist);
	}

}
