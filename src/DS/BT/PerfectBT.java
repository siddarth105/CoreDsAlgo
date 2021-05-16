package DS.BT;

public class PerfectBT {
	
    class Tree {
		  public int x;
		  public Tree l;
		  public Tree r;
		public Tree(int x) {
			super();
			this.x = x;
		}
	}
	
    class ReturnInfo {
        boolean isPerfect;
        int height;
        int maxHeightBinaryTree;
        public ReturnInfo(boolean isPerfect, int height, int maxHeightBinaryTree) {
            this.isPerfect = isPerfect;
            this.height = height;
            this.maxHeightBinaryTree = maxHeightBinaryTree;
        }
    }

    public ReturnInfo getPerfectBinaryTree(Tree tree) {

        if (tree == null) {
            return new ReturnInfo(false, 0, 0);

        }
        if ((tree.l == null && tree.r == null)) {
            return new ReturnInfo(true, 0, 0);
        }
        ReturnInfo returnAtThisLevel = new ReturnInfo(true, 0, 0);
        ReturnInfo leftReturn = getPerfectBinaryTree(tree.l);//2 -
        ReturnInfo rightReturn = getPerfectBinaryTree(tree.r);//3

        if (leftReturn.isPerfect && rightReturn.isPerfect) {
            returnAtThisLevel.isPerfect = true;
            if (leftReturn.height == rightReturn.height) {
                returnAtThisLevel.height = leftReturn.height + 1;
                returnAtThisLevel.maxHeightBinaryTree = returnAtThisLevel.height ;
            }else {
                returnAtThisLevel.maxHeightBinaryTree = Math.max(leftReturn.maxHeightBinaryTree, rightReturn.maxHeightBinaryTree) ;
            }
        } else {
            returnAtThisLevel.maxHeightBinaryTree = Math.max(leftReturn.maxHeightBinaryTree, rightReturn.maxHeightBinaryTree);
        }
        return returnAtThisLevel;
    }
    
    
    public int solution(Tree T) {
         if (T == null) {
            return 0;
        }
        ReturnInfo returnInfo = getPerfectBinaryTree(T);
        int height = returnInfo.maxHeightBinaryTree;
        double ans = Math.pow(2, height + 1) - 1;
        return (int) Math.round(ans);
    }
}
