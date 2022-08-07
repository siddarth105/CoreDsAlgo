package DS.LinkedList;

public class MergeSortedSLL {
	
	static SListNode<Integer> head1;
	static SListNode<Integer> head2;
	
	static void printList (SListNode<Integer> node) {
		
		while (null != node) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		
		System.out.println();
	}
	
	static SListNode<Integer> mergeLst(SListNode<Integer> node1, SListNode<Integer> node2) {
		
		if (null == node1)
			return node2;
		
		if (null == node2)
			return node1;
		
		SListNode<Integer> temp =  null;
		
		if (node1.data < node2.data) {
			temp = node1;
			node1.next = mergeLst(node1.next, node2);
		} else {
			temp = node2;
			node2.next = mergeLst(node1, node2.next);
		}
		
		return temp;
	}
	
	public static void main(String[] args) {
		
		head1 = new SListNode<Integer>(1);
		head1.next = new SListNode<Integer>(8);
		
		head2 = new SListNode<Integer>(2);
		head2.next = new SListNode<Integer>(3);
		head2.next.next = new SListNode<Integer>(10);
		head2.next.next.next = new SListNode<Integer>(12);
		
		printList(head1);
		printList(head2);
		
		SListNode<Integer> mergeLst = mergeLst(head1, head2);
		
		printList(mergeLst);
	}

}
