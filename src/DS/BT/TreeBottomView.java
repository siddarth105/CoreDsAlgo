package DS.BT;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TreeBottomView {
	
	 
	static TreeNode root;
	 
	public void bottomView() {
		
		if (root == null)
			return;

		int hd = 0;
		Map<Integer, Integer> map = new TreeMap<>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		root.vd = hd;
		queue.add(root);

		while (!queue.isEmpty()) {
			
			TreeNode temp = queue.remove();
			hd = temp.vd;
			map.put(hd, temp.data);
			
			if (temp.left != null) {
				temp.left.vd = hd - 1;
				queue.add(temp.left);
			}
			if (temp.right != null) {
				temp.right.vd = hd + 1;
				queue.add(temp.right);
			}
		}
		
		for (Map.Entry<Integer, Integer> me : map.entrySet()) {
			System.out.print(me.getValue() + " ");
		}
	}

	public static void main(String[] args) {
		TreeBottomView tbv = new TreeBottomView();
		root = new TreeNode(20);
		root.left = new TreeNode(8);
		root.right = new TreeNode(22);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(25);
		root.left.right.left = new TreeNode(10);
		root.left.right.right = new TreeNode(14);
		System.out.println("Bottom view of the given binary tree:");
		tbv.bottomView();
	}
}
