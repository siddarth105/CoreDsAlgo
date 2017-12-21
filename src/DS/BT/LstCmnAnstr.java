package DS.BT;

/*		1) BASE CASE
 		2) RECURSION
		3) OUTPUT_CASE_1
		4) OUTPUT_CASE_2
		5) BACK_TRACK		*/

public class LstCmnAnstr {

	static TreeNode root;
	static boolean v1 = false;
	static boolean v2 = false;

	public TreeNode findLCA(int n1, int n2) {
		return findLCA(root, n1, n2);
	}

	// This function assumes that n1 and n2 are present in Binary DiagonalSum
	public static TreeNode findLCA(TreeNode trNd, int n1, int n2) {

		// BASE CASE :-
		if (trNd == null) {
			return null;
		}

		// OUTPUT_CASE_1 :-
		// If either n1 or n2 matches with root's key, report the presence
		if (trNd.data == n1 || trNd.data == n2) {
			return trNd;
		}

		// RECURSION :-
		// Look for keys in left and right subtrees
		TreeNode left_lca = findLCA(trNd.left, n1, n2);
		TreeNode right_lca = findLCA(trNd.right, n1, n2);

		// OUTPUT_CASE_2 :-
		if (left_lca != null && right_lca != null) {
			return trNd;
		}

		// BACK_TRACK :-
		// If both are null -> Go back with Null
		// If any 1 is present -> Go back with Not Null
		return (left_lca != null) ? left_lca : right_lca;
	}
	
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

	public static void main(String args[]) {
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
		
		//TreeNode nd = tree.findLCA(n1, n2);
		
		TreeNode nd = findLCA2(root, n1, n2);
		
		if(nd == null) {
			System.out.println("Both the elements are not present in tree");
		} else {
			
			if (v1 && v2) {
				System.out.println("LCA("+n1+", "+n2+") = " + nd.data);
			} else {
				System.out.println("One element is not in Tree");
			}
		}
		
		/*
		int n1 = 4;
		int n2 = 7;
		int n1 = 4;
		int n2 = 6;
		int n1 = 3;
		int n2 = 4;
		int n1 = 2;
		int n2 = 4;*/
	}
}
