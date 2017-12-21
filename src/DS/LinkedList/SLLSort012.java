package DS.LinkedList;

public class SLLSort012 {

	static SListNode<Integer> head;

	public static void add(int[] val) {

		head = new SListNode<Integer>(val[0]);
		SListNode<Integer> last = head;
		for (int i = 1; i < val.length; i++) {
			SListNode<Integer> cur = new SListNode<Integer>(val[i]);
			last.next = cur;
			last = last.next;
		}

	}
	
	public static void printLst (SListNode<Integer> nHead) {
		
		SListNode<Integer> temp = nHead;
		while (null != temp) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public static void orderLst () {
		
		SListNode<Integer> zeroD = new SListNode<Integer>(0); 
		SListNode<Integer> oneD = new SListNode<Integer>(1);
		SListNode<Integer> twoD = new SListNode<Integer>(2);
		
		SListNode<Integer> zero = zeroD;
		SListNode<Integer> one = oneD;
		SListNode<Integer> two = twoD;
		
		SListNode<Integer> cur = head;
		
		while (cur != null) {
			
			if (cur.data == 0) {
				zero.next = cur;
				zero = zero.next;
			} else if (cur.data == 1) {
				one.next = cur;
				one = one.next;
			} else {
				two.next = cur;
				two = two.next;
			}
			cur = cur.next;
		}
		
		System.out.print("zeroD : ");
		printLst(zeroD);
		System.out.print("oneD : ");
		printLst(oneD);
		System.out.print("twoD : ");
		printLst(twoD);
		
		//The existing list is been modified
		System.out.print("head : ");
		printLst(head);
		
		zero.next = (oneD.next) != null ? (oneD.next) : (twoD.next);
	    one.next = twoD.next;
	    two.next = null;
	    
	    head = zeroD.next;
		
	    System.out.print("head : ");
		printLst(head);
	}

	public static void main(String[] args) {

		int[] val = new int[] { 1, 2, 2, 1, 2, 0, 2, 2, 0};
		add(val);
		System.out.print("head : ");
		printLst(head);
		orderLst();
	}

}
