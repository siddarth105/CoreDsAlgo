package DS.LinkedList;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class LstRev {
	
	static SListNode<Integer> head;
	
	public static void revList(){
		
		SListNode prev = null;
		SListNode current = head;
		SListNode next = null;
		while (null != current) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
	}
	
	public static void swapAlt() {
		
		SListNode node = head;
		
		//Initialise by shifting 1 node ahead
		SListNode prev = node;
        SListNode curr = node.next;
        SListNode nxt = curr.next;
        node = curr;	// Mark the head of the node
        
        while (null != nxt) {
        	
        	if (nxt.next == null) {
            	break;
            }
        	
        	// Swap current & prev 
        	curr.next = prev;
        	prev.next = nxt.next;
        	
            //Move current by 2 nodes
        	prev = nxt;
            curr = prev.next;
            nxt = curr.next;
        }
        curr.next = prev;
        prev.next = nxt;
        
        head = node;
	}
	
	public static SListNode swapK(SListNode head, int k) {

		SListNode current = head;
		SListNode next = null;
		SListNode prev = null;

		int count = 0;

		while (count < k && current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}

		if (next != null)
			head.next = swapK(next, k);

		return prev;

	}
	
	
	public static void main(String[] args) {
		
		head = new SListNode<Integer>(1);
		head.next = new SListNode<Integer>(2);
		head.next.next = new SListNode<Integer>(3);
		head.next.next.next = new SListNode<Integer>(4);
		head.next.next.next.next = new SListNode<Integer>(5);
		head.next.next.next.next.next = new SListNode<Integer>(6);
		//printList();
		//revList();
		//head = pairWiseSwap(head);
		//swapAlt();
		head = swapK(head, 4);
		printList();
	}
	
	public static void printList() {
		SListNode<Integer> nd = head;
		while (nd != null) {
			System.out.print(nd.data + " ");
			nd = nd.next;
		}
		System.out.println();
	}

}