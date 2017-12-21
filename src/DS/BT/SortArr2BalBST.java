package DS.BT;

public class SortArr2BalBST {
	
	static TreeNode root;
	
	static TreeNode sortedArrayToBST(int arr[], int start, int end) {
        
		if (start > end) {
            return null;
        }
 
        int mid = (start + end) / 2;
        
        TreeNode node = new TreeNode(arr[mid]);
        node.left = sortedArrayToBST(arr, start, mid - 1);
        node.right = sortedArrayToBST(arr, mid + 1, end);
        return node;
    }
	
	static void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }
	
	public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7};
        int n = arr.length;
        root = sortedArrayToBST(arr, 0, n - 1);
        System.out.println("InOrder traversal of constructed BST");
        inOrder(root);
    }

}
