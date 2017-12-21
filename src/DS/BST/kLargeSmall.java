package DS.BST;

import java.util.Stack;

public class kLargeSmall {
	
	static Node root;
	static int kLrgCnt = 0;
	static int kSmlCnt = 0;
	
	 /*	TIME_COMPLEXITY :: O(n), n -> total nodes in tree	
	  * SPACE_COMPLEXITY :: O(n)
	 *	ALGORITHM ::
	 * 	Push all the left into stack
	 *  For each node(let node be x) pop decrement k by 1
	 *  When k reaches 0 -> return the node
	 *  If x has right child, push the right and all the left-> sub-children of right into stack 
	 *  Repeat until stack becomes empty */
	
	static Node k_smallest_element_inorder(int k) {
		
		Stack<Node> stk = new Stack<Node>();
		Node nd = root;
		
		while(null != nd) {
			stk.push(nd);
			nd = nd.left;
		}
		
		while(!stk.isEmpty()){
			nd = stk.pop();
			--k;
			if(k == 0) {
				return nd;
	        }
			if (nd.right != null){
				nd = nd.right;
				while(null != nd) {
					stk.push(nd);
					nd = nd.left;
				}
			}
		}
		
		return null;
	}
	
	
	static Node k_largest_element_inorder(int k) {
		
		Stack<Node> stk = new Stack<Node>();
		Node nd = root;
		
		while(null != nd) {
			stk.push(nd);
			nd = nd.right;
		}
		
		while(!stk.isEmpty()){
			nd = stk.pop();
			--k;
			if(k == 0) {
				return nd;
	        }
			if (nd.left != null){
				nd = nd.left;
				while(null != nd) {
					stk.push(nd);
					nd = nd.right;
				}
			}
		}
		
		return null;
	}
	
	//TIME_COMPLEXITY :: O(h+k)
	static Node kLargeInOrder(Node nd){
		//BASE_CASE
		if (nd == null)
			return null;
		
		Node nd1 = kLargeInOrder(nd.right);
		
		kLrgCnt--;
		if (kLrgCnt == 0) {
			return nd;
		}
	
		Node nd2 = kLargeInOrder(nd.left);
		
		return (nd1 != null)? nd1 : nd2;
	}
	
	static Node kSmallInOrder(Node nd){
		//BASE_CASE
		if (nd == null)
			return null;
		
		Node nd2 = kSmallInOrder(nd.left);
		
		kSmlCnt--;
		if (kSmlCnt == 0) {
			return nd;
		}
	
		Node nd1 = kSmallInOrder(nd.right);
		
		return (nd1 != null)? nd1 : nd2;
	}
	
	// TIME_COMPLEXITY :: O(n)
	// SPACE_COMPLEXITY :: O(1)
	static Node morrisTrvslSmall(Node node, int k) {

		Node current, pre;
		current = node;
		
		int count = 0;
		Node kNode = null;

		while (current != null) {
			if (current.left == null) {
				count++;
				if(count == k){
					kNode = current;
					return kNode;
				}
				current = current.right;
			} else {

				pre = current.left;
				while (pre.right != null && pre.right != current) {
					pre = pre.right;
				}

				if (pre.right == null) {
					pre.right = current;
					current = current.left;
				} else {
					
					pre.right = null;
					count++;
					if(count == k){
						kNode = current;
						return kNode;
					}
					current = current.right;
				}
			}
		}
		
		return kNode;
	}
	
	
	//http://www.geeksforgeeks.org/kth-smallest-element-in-bst-using-o1-extra-space/
	public static void main(String[] args) {

		insert(50);
		insert(30);
		insert(20);
		insert(40);
		insert(70);
		insert(60);
		insert(80);
		
		inorder();
		
		kSmlCnt = 7;
		/*		morrisTrvslSmall(root, 7);		
				k_smallest_element_inorder(7);		
				kSmallInOrder(root)		*/
		Node k = morrisTrvslSmall(root, 7);  
		if (null != k) {
			System.out.println("k-th smallest element is :: " +k.key);
		} else {
			System.out.println("No such element");
		}
		
		kLrgCnt = 7;
		Node l = kLargeInOrder(root); /*	k_largest_element_inorder(7)	*/
		if (null != l) {
			System.out.println("k-th largest element is :: " +l.key);
		} else {
			System.out.println("No such element");
		}
	}
	
	
	static void insert(int key) {
		root = Node.insertRec(root, key);
	}
	
	static void inorder() {
		Node.inorderRec(root);
		System.out.println();
	}
}
