package DS.BT;
// https://www.geeksforgeeks.org/clone-binary-tree-random-pointers/
public class CloneWithRdmPointers {
    // Below is the code to clone a normal tree

    public static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    public static TreeNode clone(TreeNode root) {
        if (root == null)
            return null;

        TreeNode clonedRoot = new TreeNode(root.val);
        clonedRoot.left = clone(root.left);
        clonedRoot.right = clone(root.right);

        return clonedRoot;
    }

    public static void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Original Tree:");
        inorderTraversal(root);
        System.out.println();

        TreeNode clonedRoot = clone(root);

        System.out.println("Cloned Tree:");
        inorderTraversal(clonedRoot);
        System.out.println();
    }

}
