package DS.LinkedList;

public class SListNode<T> {

	T data;
	SListNode<T> next;
	SListNode<T> rdm;
	SListNode<T> dwn;

	public SListNode(T data) {
		this.data = data;
	}

	public SListNode() {
		super();
	}
}
