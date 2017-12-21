package DS.BT;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class TreeTopView {
	
	static TreeNode root;
	
	public static void printTopView (){
		if (root == null) {  
			return;  
		}
		
		Set<Integer> set = new HashSet<Integer>();
		Queue<TreeNode> q = new ArrayDeque<TreeNode>();
		root.vd = 0;
		q.add(root);
		
		//Breadth First Traversal using Queue
		while(!q.isEmpty()) {
			TreeNode n = q.remove();
			int hd = n.vd;
			
			if (!set.contains(hd)) {
                set.add(hd);
                System.out.print(n.data + " ");
            }
			
			if (n.left != null) {
				n.left.vd = hd-1;
                q.add(n.left);
			}
            if (n.right != null) {
            	n.right.vd = hd+1;
            	q.add(n.right);
            }
		}
	}
	
	public static void main(String[] args) {
		
		TreeNode tree = new TreeNode(1);
 
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        
        tree.left.right.left = new TreeNode(6);
        tree.left.right.right = new TreeNode(7);
        
        root = tree;
        
        printTopView();
        
        /*
         
          Assign Horizontal Distance "hd" for each node, by creating a variable hd in the node class
          Initialise hd = 0 for root and add root to queue
          BFT
          Use set to avoid duplicates
          While in BFT, calculate the hd and assign to each node
          
          
			       1 :0
			    /       \
		-1:	   2          3    :+1
			 /   \       
	-2:		4     5:0  
			    /   \
			-1:6     7:+1
	        
	      */
	}

}
