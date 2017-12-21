package DS.BT;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class DiagonalSum {

	TreeNode root;

	public DiagonalSum(TreeNode root) {
		this.root = root;
	}

	public void diagonalSum() {
		
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();

		root.vd = 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		while (!queue.isEmpty()) {
			// Remove the front tree node from queue.
			TreeNode curr = queue.remove();

			// Get the vertical distance of the dequeued node.
			int vd = curr.vd;

			// Sum over this node's right-child, right-of-right-child and so on
			while (curr != null) {
				int prevSum = (map.get(vd) == null) ? 0 : map.get(vd);
				map.put(vd, prevSum + curr.data);

				// If for any node the left child is not null add
				// it to the queue for future processing.
				if (curr.left != null) {
					curr.left.vd = vd + 1;
					queue.add(curr.left);
				}

				// Move to the current node's right child.
				curr = curr.right;
			}
		}

		// Traverse the map elements using the iterator.
		System.out.println("Diagonal sum in a binary tree is :- ");
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.println("Diagonal_"+ entry.getKey() + " :: " + entry.getValue());
		}
	}
	
	public static void main(String[] args) {
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
		DiagonalSum tree = new DiagonalSum(root);
		tree.diagonalSum();
	}
	
	/*
	Algorithm :-
	
	1. Add root with vertical distance as 0 to the queue.
	2. Process the sum of all right child and right of right child and so on.
	3. Add left child current node into the queue for later processing. The vertical distance of left child is vertical distance of current node plus 1.
	4. Keep doing 2nd, 3rd and 4th step till the queue is empty.
	*/
}