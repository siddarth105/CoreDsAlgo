package DS.BT;

public class TreeNode {
	
	int data, vd;
	TreeNode left, right;
 
    public TreeNode(int item) {
        data = item;
        vd = Integer.MAX_VALUE;
        left = right = null;
    }
    
    public TreeNode() {
    }

}
