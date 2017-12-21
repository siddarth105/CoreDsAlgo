package Pbm;

import java.util.Arrays;
import java.util.Collections;

public class EltFrqBST {
	
	static int a[];
	static Node root;
	static int nodeCount = 0;
	static DataFreq[] count;
	static int index;
	
	public class Node {
		
		public int data, freq;
		public Node lt, rt;
		
		public Node(int data) {
			this.data = data;
			this.freq = 1;
			this.lt = null; this.rt = null;
		}
	}
	
	public class DataFreq implements Comparable<DataFreq>{
		public int data, freq;

		public DataFreq(int data, int freq) {
			this.data = data;
			this.freq = freq;
		}

		@Override
		public int compareTo(DataFreq o) {
			if (this.freq < o.freq) {
				return -1;
			}
			return 1;
		}
	}
	
	public static void inOrder(Node nd, DataFreq[] count, EltFrqBST eltFrqBST) {
		if (null == nd) {
			return;
		}
		inOrder(nd.lt, count, eltFrqBST);
		
		count[index] = eltFrqBST.new DataFreq(nd.data, nd.freq);
		index++;
		
		inOrder(nd.rt, count, eltFrqBST);
	}
	
	public static Node insert(Node nd, int data, EltFrqBST eltFrqBST) {
		
		if (null == nd) {
			nodeCount++;
			return eltFrqBST.new Node(data);
		}
		
		if (data == nd.data) {
			nd.freq = nd.freq + 1;
		} else if (data < nd.data){
			nd.lt = insert(nd.lt,data,eltFrqBST);
		} else {
			nd.rt = insert(nd.rt,data,eltFrqBST);
		}
		
		return nd;
	}
	
	public static void sortByFreq (EltFrqBST eltFrqBST) {
		// O(n log n)
		for (int i = 0; i < a.length; i++) {
			root = insert(root, a[i], eltFrqBST);	
		}
		
		// O(n)
		count = new DataFreq[nodeCount];
		inOrder(root, count, eltFrqBST);
		
		// O(n log n)
		Collections.sort(Arrays.asList(count));
		
		//O(n)
		for (DataFreq df : count) {
			for (int i = 0 ; i < df.freq; i++) {
				System.out.print(df.data +" ");
			}
		}
	}
	
	public static void main(String[] args) {
		
		EltFrqBST eltFrqBST = new EltFrqBST();
		a = new int[] { 5, 2, 2, 8, 5, 6, 8, 8 };
		sortByFreq(eltFrqBST);
		
	}

}
