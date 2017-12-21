package DS.CustomDS;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	
	static DDLNode head;
	static DDLNode tail;
	static Map<Integer, DDLNode> mp = new HashMap<Integer, DDLNode>();
	
	static int getVal(int k) {
		
		DDLNode newNd = null;
		if (null == mp.get(k)) {
			newNd = new DDLNode(k);
			if (null == head) {
				head = newNd;
				tail = head;
			} else {
				tail.next = newNd;
				newNd.prev = tail;
				tail = newNd;;
			}
			mp.put(k, newNd);
			
		} else {
			
			newNd = mp.get(k);
			newNd.prev.next = newNd.next;
			newNd.next.prev = newNd.prev;
			
			newNd.next = head;
			newNd.prev = null;
			head = newNd;
		}
			
		printList();
		return -1;
	}
	
	static void printList() {
		
		DDLNode cur = head;
		
		while (null != cur) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}
		
		System.out.println();
	}
	
	public static void main (String[] args) {
		
		getVal(1);
		getVal(2);
		getVal(3);
		getVal(4);
		getVal(3);
		
	}

}
