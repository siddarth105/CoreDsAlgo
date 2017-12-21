package DS.Trie;

public class DLLNode {
	
	String data;
	DLLNode next, prev;
	
	// Returns the head of the list, getting the head of the list
	DLLNode insert(DLLNode head_ref, String new_data) {
		
		DLLNode new_node = new DLLNode();

		new_node.data = new_data;
		if (head_ref.data != null) {
			new_node.next = head_ref;
		} else {
			new_node.next = null;
		}
		new_node.prev = null;

		// change prev of head node to new node
		if (head_ref.data != null) {
			head_ref.prev = new_node;
		}
		
		head_ref = new_node;
		
		return head_ref;
	}
	
	DLLNode deleteNode(DLLNode head_ref, DLLNode del) {
		// base case
		if (head_ref == null || del == null)
			return null;

		// If node to be deleted is head node
		if (head_ref == del)
			head_ref = head_ref.next;

		// If node to be deleted is NOT the last node
		if (del.next != null)
			del.next.prev = del.prev;

		// If node to be deleted is NOT the first node
		if (del.prev != null)
			del.prev.next = del.next;

		del = null;
		return head_ref;
	}

}
