package DS.BT;

public class EltLvl {
	
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
	 
    // Constructors
	EltLvl(int key) {
        root = new Node(key);
    }
 
	EltLvl() {
        root = null;
    }
	
	public int getLevel(Node rt, int ndData, int lvl){

		if (rt == null) 
			return 0;
		if(rt.key == ndData)
			return lvl;
		
		int downlevel = getLevel(rt.left, ndData, lvl + 1);
        
		if (downlevel != 0)
            return downlevel;
  
        downlevel = getLevel(rt.right, ndData, lvl + 1);
        return downlevel;
	}
	
	public static void main(String[] args)
    {
		EltLvl tree = new EltLvl();
 
        /*create root*/
        tree.root = tree.new Node(1);
 
        tree.root.left = tree.new Node(2);
        tree.root.right = tree.new Node(3);
        
        tree.root.left.left = tree.new Node(4);
        tree.root.left.right = tree.new Node(5);
        
        tree.root.left.right.left = tree.new Node(6);
        tree.root.left.right.right = tree.new Node(7);
        
        int k = tree.getLevel(tree.root, 3, 1);
        System.out.println("Level of the given node is :: " + k);
    }

}
