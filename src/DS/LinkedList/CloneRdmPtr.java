package DS.LinkedList;

public class CloneRdmPtr {
	
	static SListNode<Integer> head;
	
	public static void cloneLst(){
		SListNode<Integer> nd = head;
		SListNode<Integer> clNd = null;
		while (nd != null) {
			
			clNd = new SListNode<Integer>(nd.data);
			SListNode<Integer> temp = nd.next;
			nd.next = clNd;
			clNd.next = temp;
			nd = temp;
		}
		printList(head);
	}
	
	public static SListNode<Integer> cloneRdm(){
		SListNode<Integer> nd = head;
		SListNode<Integer> clNd = head.next;
		SListNode<Integer> clHd = clNd;
		while (clNd != null) {
			clNd.rdm = nd.rdm.next;
			nd = clNd.next;
			if (null == nd) {
				break;
			}
			clNd.next = nd.next;
			clNd = nd.next;
		}
		return clHd;
	}
	
	
	public static void main(String[] args){
		makeList();
		//Create the copy of node 1 and insert it between node 1 & node 2 in original Linked List
		cloneLst();
		//Now copy the random pointer & restore the list
		SListNode<Integer> clHd = cloneRdm();
		printRdm(clHd);
	}
	
	private static void makeList(){
		
		head = new SListNode<Integer>(1);
		head.next = new SListNode<Integer>(2);
		head.next.next = new SListNode<Integer>(3);
		head.next.next.next = new SListNode<Integer>(4);
		head.next.next.next.next = new SListNode<Integer>(5);
		head.next.next.next.next.next = new SListNode<Integer>(6);
		
		head.rdm = head.next.next;
		head.next.rdm = head.next.next.next;
		head.next.next.rdm = head.next.next.next.next;
		head.next.next.next.rdm = head.next;
		head.next.next.next.next.rdm = head.next.next.next.next.next;
		head.next.next.next.next.next.rdm = head;
		printRdm(head);
		
	}
	
	private static void printRdm(SListNode<Integer> nd) {
		System.out.print("Random pointers of nodes :: ");
		while (nd != null) {
			System.out.print(nd.rdm.data + " ");
			nd = nd.next;
		}
		System.out.println();
	}
	
	private static void printList(SListNode<Integer> nd) {
		while (nd != null) {
			System.out.print(nd.data + " ");
			nd = nd.next;
		}
		System.out.println();
	}
}
