package DS.BT;

import java.util.LinkedList;
import java.util.List;

public class PathSumRootToLeaf {
	
	static TreeNode root;
	
	static void pathSum(TreeNode nd, int sum, List<Integer> lst) {
		
		if (nd.left == null && nd.right == null) {
			lst.add(sum);
			return;
		}
		pathSum(nd.left, sum + nd.left.data, lst);
		pathSum(nd.right, sum + nd.right.data, lst);
	}
	
	
	public static void main(String args[]) {
		root = new TreeNode(1);
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.right.left = new TreeNode(6);
		root.left.right.right = new TreeNode(7);
		List<Integer> lst = new LinkedList<Integer>();
		pathSum(root, root.data, lst);
		int sum = 0;
		for (Integer k : lst) {
			sum = sum + k;
		}
		System.out.println("Total path sum : " + sum);
	}

}
