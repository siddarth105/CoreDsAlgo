package DS.BT;

public class DistBetweenNodes {

	// http://www.geeksforgeeks.org/find-distance-between-two-nodes-of-a-binary-tree/
	// Distance between 2 nodes = Level of node A from LCA + Level of node B
	// from LCA

	static TreeNode root;
	static boolean v1 = false;
	static boolean v2 = false;

	public static TreeNode findLCA2(TreeNode trNd, int n1, int n2) {

		// BASE CASE :-
		if (trNd == null) {
			return null;
		}

		// OUTPUT_CASE_1 :-
		// If either n1 or n2 matches with root's key, report the presence
		if (trNd.data == n1 && !v1) {
			v1 = true;
			findLCA2(trNd.left, n1, n2);
			findLCA2(trNd.right, n1, n2);
			return trNd;
		}

		if (trNd.data == n2 && !v2) {
			v2 = true;
			findLCA2(trNd.left, n1, n2);
			findLCA2(trNd.right, n1, n2);
			return trNd;
		}

		// RECURSION :-
		// Look for keys in left and right subtrees
		TreeNode left_lca = findLCA2(trNd.left, n1, n2);

		if (v1 && v2 && (null != left_lca && (n1 == left_lca.data || n2 == left_lca.data))) {
			return left_lca;
		}

		TreeNode right_lca = findLCA2(trNd.right, n1, n2);

		// OUTPUT_CASE_2 :-
		if (left_lca != null && right_lca != null) {
			return trNd;
		}

		if (v1 && v2 && (null != right_lca && (n1 == right_lca.data || n2 == right_lca.data))) {
			return right_lca;
		}

		// BACK_TRACK :-
		// If both are null -> Go back with Null
		// If any 1 is present -> Go back with Not Null
		return (left_lca != null) ? left_lca : right_lca;
	}

	public static int nodeDis(int n1, int n2) {

		TreeNode lca = findLCA2(root, n1, n2);
		
		int dist = -1;

		if (lca == null) {
			System.out.println("Both the elements are not present in tree");
			return dist;
		}

		if (v1 && v2) {
			
			System.out.println("LCA(" + n1 + ", " + n2 + ") = " + lca.data);
			int n1Dist = findDist(lca, n1, 0);
			int n2Dist = findDist(lca, n2, 0);
			dist = n1Dist + n2Dist;
			
		} else {
			System.out.println("One element is not in Tree");
		}

		return dist;
	}

	public static int findDist(TreeNode nd, int ndVal, int lvl) {

		if (null == nd)
			return 0;

		if (nd.data == ndVal)
			return lvl;

		int ltLvl = findDist(nd.left, ndVal, lvl + 1);
		int rtLvl = findDist(nd.right, ndVal, lvl + 1);

		return (ltLvl != 0) ? ltLvl : rtLvl;
	}

	public static void main(String[] args) {

		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.left.left = new TreeNode(8);
		root.left.right.left = new TreeNode(6);
		root.left.right.right = new TreeNode(7);

		int n1 = 4;
		int n2 = 6;

		System.out.println("Distance between " + n1 + "and " + n2 + " is :" + nodeDis(n1, n2));
	}

}
