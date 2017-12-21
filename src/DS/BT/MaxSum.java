package DS.BT;

//Maximum path sum between any two nodes in a BT 
public class MaxSum {
	
	static TreeNode root;
	
	static int findMaxUtil(TreeNode node, Res res) {
 
        if (node == null)
            return 0;
 
        int l = findMaxUtil(node.left, res);
        int r = findMaxUtil(node.right, res);
 
        // max_single =  max(max( 2, 3), 1)
        int max_single = Math.max(Math.max(l, r) + node.data, node.data);
        
        // max_top = max(max_single, 4)
        int max_top = Math.max(max_single, l + r + node.data);
 
        // Store the Maximum Result
        res.r = Math.max(res.r, max_top);
 
        return max_single;
    }
	
	
	static int findMaxSum() {
		 
        Res res = new Res();
        findMaxUtil(root, res);
        return res.r;
    }
	

	public static void main(String args[]) {
		root = new TreeNode(10);
		root.left = new TreeNode(2);
		root.right = new TreeNode(10);
		root.left.left = new TreeNode(20);
		root.left.right = new TreeNode(1);
		root.right.right = new TreeNode(-25);
		root.right.right.left = new TreeNode(3);
		root.right.right.right = new TreeNode(4);
		System.out.println("maximum path sum is : " + findMaxSum());
	}
	
	/* ALGORITHM
	
	For each node there can be four ways that the max path goes through the node:
		1. Node only
		2. Max path through Left Child + Node
		3. Max path through Right Child + Node
		4. Max path through Left Child + Node + Max path through Right Child
		
	*/
}
