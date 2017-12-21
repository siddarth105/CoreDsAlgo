package DS.BT;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class BoundaryTrav {
	
	
	class Node {

		int data;
		Node left, right;
		int vd;
		Node(int item) {
			data = item;
			left = right = null;
		}
	}
	
	Node root;
	static Map<Integer, List<Node>> hMap = new TreeMap<Integer, List<Node>>();
	static Map<Integer, List<Node>> hMap2 = new TreeMap<Integer, List<Node>>();
	static int maxLvl = 0;
	
	public static void printLeft(Node nd){
		if (nd != null) {
			if (nd.left != null) {
				System.out.print(nd.data + " ");
				printLeft(nd.left);
			} else if (nd.right != null) {
				System.out.print(nd.data  + " ");
				printLeft(nd.left);
			}
		}
	}
	
	
	public static void printRight(Node nd){
		if (nd != null) {
			if (nd.right != null) {
				printRight(nd.right);
				System.out.print(nd.data  + " ");
			} else if (nd.left != null) {
				printRight(nd.right);
				System.out.print(nd.data  + " ");
			}
		}
	}
	
	public static void printLeaf(Node nd) {
		if (nd != null) {
			printLeaf(nd.left);
			
			if (nd.left == null && nd.right == null) 
				System.out.print(nd.data  + " ");
			
			printLeaf(nd.right);
		}
	}
	
	/*	TIME_COMPLEXITY :: O(n)	*/
	public static void printBoundary(Node nd){
		
		if (nd != null) {
			System.out.print(nd.data + " ");
			printLeft(nd.left);
			
			printLeaf(nd.left);
			printLeaf(nd.right);
			
			printRight(nd.right);
		}
	}
	
	
	/*********************************************************************************************************/
	
	/*ALGORITHM :-
	 * 1. PreOrder traversal
	 * 2. Construct a map with 
	 *		Key(lvl) :: Value(List<Node @ lvl>)
	 * 3. Left Boundary -> left extreme at each lvl
	 * 4. Right Boundary -> right extreme node at each level + vd (right extreme node) > vd (right extreme node of prev lvl)  
	 * 5. Bottom Boundary -> all nodes at max lvl*/
	
	public static void preOrder1(Node nd, int lvl, int vd){
		
		if (nd == null) 
			return;
		
		if (lvl > maxLvl) {
			maxLvl = lvl;
		}
		
		nd.vd = vd;
		
		if(hMap2.containsKey(lvl)){
			List<Node> ndList = hMap2.get(lvl);
			ndList.add(nd);
		} else {
			List<Node> ndList = new LinkedList<Node>();
			ndList.add(nd);
			hMap2.put(lvl, ndList);
		}
		
		preOrder1(nd.left, lvl+1, vd-1);
		preOrder1(nd.right, lvl+1, vd+1);
	}
	
	public static void printBoundary1(Node nd){
		preOrder1(nd, 0, 0);
		Stack<Node> stk = new Stack<Node>();
		stk.add(nd);
		
		for(int i = 0; i <= maxLvl; i++) {
			List<Node> ndList = hMap2.get(i);
			if (i != maxLvl) {
				System.out.print(ndList.get(0).data + " ");
				
				int rtEx = ndList.size() - 1;
				int rtExVd = ndList.get(rtEx).vd;
				if (rtExVd > stk.peek().vd)
					stk.push(ndList.get(rtEx));
				
			} else {
				for (Node nde : ndList) {
					System.out.print(nde.data + " ");
				}
			}
		}
		
		while (!stk.isEmpty()) {
			System.out.print(stk.pop().data + " ");
		}
	}
	
	/*************************************************************************************************************/
	
	public static void preOrder2(Node nd, int lvl){
		
		if (nd == null) 
			return;
		
		if (lvl > maxLvl) {
			maxLvl = lvl;
		}
		
		if(hMap.containsKey(lvl)){
			List<Node> ndList = hMap.get(lvl);
			ndList.add(nd);
		} else {
			List<Node> ndList = new LinkedList<Node>();
			ndList.add(nd);
			hMap.put(lvl, ndList);
		}
		
		preOrder2(nd.left, lvl+1);
		preOrder2(nd.right, lvl+1);
	}
	
	public static void printBoundary2(Node nd){
		preOrder2(nd, 0);
		Stack<Integer> stk = new Stack<Integer>();
		
		for(int i = 0; i <= maxLvl; i++) {
			List<Node> ndList = hMap.get(i);
			if (i != maxLvl) {
				System.out.print(ndList.get(0).data + " ");
				int rtEx = ndList.size() - 1;
				stk.push(ndList.get(rtEx).data);
			} else {
				for (Node nde : ndList) {
					System.out.print(nde.data + " ");
				}
			}
		}
		
		while (!stk.isEmpty()) {
			System.out.print(stk.pop() + " ");
		}
	}
	
/******************************************************************************************************************/	
	
	public static void main(String[] args) {
		BoundaryTrav tree = new BoundaryTrav();

		/* create root */
		tree.root = tree.new Node(1);

		tree.root.left = tree.new Node(2);
		tree.root.right = tree.new Node(3);

		tree.root.left.left = tree.new Node(4);
		tree.root.left.right = tree.new Node(5);

		tree.root.left.right.left = tree.new Node(6);
		tree.root.left.right.right = tree.new Node(7);
		
		System.out.println("Triangular Boundry");
		printBoundary(tree.root);
		System.out.println();
		printBoundary1(tree.root);
		System.out.println();
		printBoundary2(tree.root);
		
	}

}
