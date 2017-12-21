package DS.BT;
 
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/*	TIME_COMPLEXITY :: O(n)
	SPACE_COMPLEXITY :: O(1)	*/

public class BinaryTree {
	
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
	
	// Root of Binary DiagonalSum
    Node root;
 
    // Constructors
    BinaryTree(int key) {
        root = new Node(key);
    }
 
    BinaryTree() {
        root = null;
    }
    
    // Using recursion	-> 4, 2, 6, 5, 7, 1, 3
    public void inOrder(Node nd) {
		
		if (nd == null) 
			return;
		
		inOrder(nd.left);
		System.out.print(nd.key + " ");
		inOrder(nd.right);
		
	}
    
    // Using recursion	-> 1,2,4,5,6,7,3
    public void preOrder(Node nd) {
		
		if (nd == null) 
			return;
		
		System.out.print(nd.key + " ");
		preOrder(nd.left);
		preOrder(nd.right);
		
	}
    
    /* Clone Binary Tree */
    public Node clone(Node nd) {
    	
    	Node copyNd = null;
    	
    	if (nd == null) 
			return copyNd;
    	
		copyNd = new Node();
        copyNd.key = nd.key;
        copyNd.left = clone(nd.left);
        copyNd.right = clone(nd.right);
    	
    	return copyNd;
    }
    
    // Using recursion	-> 4 6 7 5 2 3 1 
    public void postOrder(Node nd) {
		
		if (nd == null) 
			return;
		
		postOrder(nd.left);
		postOrder(nd.right);
		System.out.print(nd.key + " ");
	}
    
    /*Morris Traversal -> Inorder traversal without Recursion and without stack
     				   -> Eliminate the left so that LVR = VR
     while not done
      if node has no left child
         visit node;
         go to right child;
      else 
         make node the right most child of its left sub-tree
         go to the left descendent
    */
    public void MorrisTraversal(Node node) {
    	
    	Node current, pre;
    	current = node;
    	
        if (node == null) {
            return;
        }
        
        while (current != null) {
            if (current.left == null) {
                System.out.print(current.key + " ");
                current = current.right;
            } else {
 
                pre = current.left;
                while (pre.right != null && pre.right != current) {
                    pre = pre.right;
                }
 
                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                } else {
 
                    pre.right = null;
                    System.out.print(current.key + " ");
                    current = current.right;
                }
            } 
        } 
    }
    
    
    /*Stack Traversal*/
    public void stackInorder() {
        if (root == null) {
            return;
        }
        
        Stack<Node> stack = new Stack<Node>();
        Node node = root;
         
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
         
        while (stack.size() > 0) {
           
            node = stack.pop();
            System.out.print(node.key + " ");
            if (node.right != null) {
                node = node.right;
                 
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }
    }
    
	/* function to print level order traversal of tree */
	void printLevelOrder() {
		int h = height(root);
		System.out.println("Height of the tree :: " + h);
		int i;
		for (i = 1; i <= h; i++)
			printGivenLevel(root, i);
	}
 
    /* Compute the "height" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node.*/
    public int height(Node root) {
        if (root == null) {
           return 0;
        } else {
            /* compute  height of each subtree */
            int lheight = height(root.left);
            int rheight = height(root.right);
             
            /* use the larger one */
            if (lheight > rheight)
                return(lheight+1);
            else 
            	return(rheight+1); 
        }
    }
    
    public int height2(Node root) {
        if (root == null) {
           return 0;
        } else {
            /* compute  height of each subtree */
            int lheight = height(root.left) + 1;
            int rheight = height(root.right) + 1;
             
            /* use the larger one */
            return Math.max(lheight,rheight);
        }
    }
 
    /* Print nodes at the given level */
    public void printGivenLevel (Node root ,int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.key + " ");
        else if (level > 1) {
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
        }
    }
    
    /*Breadth First Traversal Using Queue*/
    public void bftQueue(){
    	Queue<Node> q = new ArrayDeque<Node>();
    	q.add(root);
    	while (!q.isEmpty()) {
    		Node nd = q.remove();
    		System.out.print(nd.key + " ");
    		if (nd.left != null) {
    			q.add(nd.left);
    		}
    		if (nd.right != null) {
    			q.add(nd.right);
    		}
    	}
    }
    
    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
 
        /*create root*/
        tree.root = tree.new Node(1);
 
        tree.root.left = tree.new Node(2);
        tree.root.right = tree.new Node(3);
        
        tree.root.left.left = tree.new Node(4);
        tree.root.left.right = tree.new Node(5);
        
        tree.root.left.right.left = tree.new Node(6);
        tree.root.left.right.right = tree.new Node(7);
        
        /*
			        1
			    /       \
			   2          3
			 /   \       /  \
			4     5  null  null
			    /   \
			   6     7
	        
	      */
        
        //tree.MorrisTraversal(tree.root);
        //System.out.println();
        //tree.stackInorder();
        //System.out.println();
        //tree.inOrder(tree.root);
        //System.out.println();
        //Node cloneRoot = tree.clone(tree.root);
        //tree.inOrder(cloneRoot);
        //tree.preOrder(tree.root);
        //tree.postOrder(tree.root);
        tree.printLevelOrder();
        //tree.bftQueue();
    }
}

/*		
           1
		 /   \
		2     3
	  /   \   		 		
     4     5  
	/ \
   6   7


		2      
      /   \   		 		
     4     5  
   /   \
  6     7
	     \
	      1
	       \
		    3
		 
	4
	 \
      2      
	   \   		 		
		5  
      /  \
     6    7
	       \
	        1
	         \
		      3
		      
*/