package DS.LinkedList;

public class FlattenSLL {

	static SListNode<Integer> head;

	static SListNode<Integer> push(SListNode<Integer> head_ref, int data) {

		SListNode<Integer> new_node = new SListNode<Integer>(data);
		new_node.dwn = head_ref;
		head_ref = new_node;
		return head_ref;
	}
	
	static SListNode<Integer> mergeLst(SListNode<Integer> node1, SListNode<Integer> node2) {
		
		if (null == node1)
			return node2;
		
		if (null == node2)
			return node1;
		
		SListNode<Integer> temp =  null;
		
		if (node1.data < node2.data) {
			temp = node1;
			node1.dwn = mergeLst(node1.dwn, node2);
		} else {
			temp = node2;
			node2.dwn = MergeSortedSLL.mergeLst(node1, node2.dwn);
		}
		
		return temp;
	}

	static void printList() {
		SListNode<Integer> temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.dwn;
		}
		System.out.println();
	}
	
	static SListNode<Integer> flatten(SListNode<Integer> root) {
        if (root == null || root.next == null)
            return root;
 
        root.next = flatten(root.next);
 
        root = mergeLst(root, root.next);
 
        return root;
    }
	

	public static void main(String[] args) {

		head = push(head, 30);
		head = push(head, 8);
		head = push(head, 7);
		head = push(head, 5);

		head.next = push(head.next, 20);
		head.next = push(head.next, 10);

		head.next.next = push(head.next.next, 50);
		head.next.next = push(head.next.next, 22);
		head.next.next = push(head.next.next, 19);

		head.next.next.next = push(head.next.next.next, 45);
		head.next.next.next = push(head.next.next.next, 40);
		head.next.next.next = push(head.next.next.next, 35);
		head.next.next.next = push(head.next.next.next, 28);
		
		head = flatten(head);
		printList();

	}
	
	
	/* Let us create the following linked list
    5 -> 10 -> 19 -> 28
    |    |     |     |
    V    V     V     V
    7    20    22    35
    |          |     |
    V          V     V
    8          50    40
    |                |
    V                V
    30               45
*/

}
