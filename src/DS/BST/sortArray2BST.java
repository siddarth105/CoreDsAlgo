package DS.BST;

//Construct a BST with minimum height from a sorted array
public class sortArray2BST {
	
	static Node root;
	static int[] arr;
	
	public static Node constructBST(int start, int end){
		
		if(start > end)
			return null;
		
		int mid = (start + end) / 2;
		Node nd = new Node(arr[mid]);
		
		nd.left = constructBST(start, mid-1);
		nd.right = constructBST(mid+1, end); 
		
		return nd;
	}
	
	public static void inOrder(Node nd) {
		if (null == nd)
			return;
		
		inOrder(nd.left);
		System.out.print(nd.key + " ");
		inOrder(nd.right);
	}
	
	
	public static void main (String[] args) {
		arr = new int[]{1, 2, 3, 4, 5, 6, 7};
		root = constructBST(0, arr.length-1);
		inOrder(root);
	}

}
