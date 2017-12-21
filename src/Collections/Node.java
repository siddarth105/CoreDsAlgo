package Collections;

public class Node implements Comparable<Integer> {
	
	private Integer item;
    private Node next;
    
    public Integer getItem() {
        return item;
    }
    public void setItem(Integer item) {
        this.item = item;
    }
    public Node getNext() {
        return next;
    }
    public void setNext(Node next) {
        this.next = next;
    }
    
	@Override
	public int compareTo(Integer arg) {
		
		if(arg == this.item){
            return 0;
        } else {
            return 1;
        }
	}

}
