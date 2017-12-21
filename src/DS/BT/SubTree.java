package DS.BT;

public class SubTree {

	
	public boolean isSame(TreeNode nd1, TreeNode nd2) {
		
		return nd1.data == nd2.data;
	}
	
	public boolean isSub(TreeNode nd1, TreeNode nd2) {
		
		// BASE_CASE-1:-
		if (nd1 == null && nd2 == null) 
			return true;
		
		// BASE_CASE-2:-
		if (nd1 == null || nd2 == null) 
			return false;
		
		//OUTPUT_CASE + RECURSION-1
		if (isSame(nd1, nd2)) {
			//Check it is identical
			if (isIdentical(nd1, nd2))
				return true;
		}
		
		//NON-OUTPUT_CASE + RECURSION-2
		/*return isSub(nd1, nd2.left) || isSub(nd1, nd2.right);*/
		return isSub(nd1.left, nd2) || isSub(nd1.right, nd2);
	}
	
	private boolean isIdentical(TreeNode nd1, TreeNode nd2) {
		
		// BASE_CASE-1:-
		if (nd1 == null && nd2 == null) 
			return true;
				
		// BASE_CASE-2:-
		if (nd1 == null || nd2 == null) 
			return false;
		
		//OUTPUT_CASE
		if (isSame(nd1, nd2)) {
			return isIdentical(nd1.left, nd2.left) && isIdentical(nd1.right, nd2.right);
		}
		
		return false;
	}
    
    public static void main(String[] args)
    {
    	/*TreeNode root1 = new TreeNode(26);
    	root1.right = new TreeNode(3);
    	root1.right.right = new TreeNode(3);
    	root1.left = new TreeNode(10);
    	root1.left.left = new TreeNode(4);
    	root1.left.left.right = new TreeNode(30);
    	root1.left.right = new TreeNode(6);
        
        TreeNode root2 = new TreeNode(10);
        root2.right = new TreeNode(6);
        root2.left = new TreeNode(4);
        root2.left.right = new TreeNode(30);
        /*TreeNode root2 = new TreeNode(4);
        root2.right = new TreeNode(30);*/
 
        
    	TreeNode root1 = new TreeNode(5);
    	root1.right = new TreeNode(3);
    	root1.left = new TreeNode(2);
    	root1.left.left = new TreeNode(4);
    	root1.left.right = new TreeNode(5);
    	root1.left.right.left = new TreeNode(6);
    	root1.left.right.right = new TreeNode(7);
    	root1.left.right.left.left = new TreeNode(8);
    	root1.left.right.left.right = new TreeNode(9);
    	
        
        TreeNode root2 = new TreeNode(5);
    	root2.left = new TreeNode(6);
    	root2.right = new TreeNode(7);
    	root2.left.left = new TreeNode(8);
    	root2.left.right = new TreeNode(9);

        
        
        SubTree st = new SubTree();
        
        /*if(st.isSub(root2, root1)) {*/
        
        if(st.isSub(root1, root2)) {
        	System.out.println("Is a subtree");
        } else {
        	System.out.println("Not a subtree");
        }
    }
}
