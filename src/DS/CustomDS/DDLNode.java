package DS.CustomDS;

public class DDLNode {
	
	int val;
	DDLNode next;
	DDLNode prev;
	
	public DDLNode(int val, DDLNode next, DDLNode prev) {
		super();
		this.val = val;
		this.next = next;
		this.prev = prev;
	}

	public DDLNode(int val) {
		super();
		this.val = val;
	}
	
}
