package Collections;

public class LinkedLst {
	
 	private Node head;
    private Node tail;
    
    public void add(Integer elt) {
        Node nd = new Node();
        nd.setItem(elt);
        if (head == null) {
            head = nd;
        } else {
            tail.setNext(nd);
        }
        tail = nd;
    }
    
    public Integer get(int pos) {
        
        if (head != null) {
            Node tmp = head;
            for (int i=0 ; i < pos; i++) {
                tmp = tmp.getNext();
            }
            return tmp.getItem();
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
    
    public Integer size() {
        if (head != null) {
            Node tmp = head;
            int size = 1;
            while(null != tmp.getNext()) {
                tmp = tmp.getNext();
                size++;
            }
            return size;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
    
    public void remove(Integer elt) {
        if(head != null) {
            Node tmp = head;
            Node nxtItem = null;
            while (!elt.equals(tmp.getNext().getItem())) {
                tmp = tmp.getNext();
                if (tmp.getNext() == null) {
                    System.out.println("Elt not found");
                    break;
                }
            }
            Node prevItem = tmp;
            if (tmp.getNext() != null) {
                nxtItem = tmp.getNext().getNext();
                prevItem.setNext(nxtItem);
            }
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
    
    public static void main(String []args){
        
        LinkedLst lst = new LinkedLst();
        lst.add(1);
        lst.add(2);
        lst.add(3);
        lst.add(4);
        
        lst.remove(8);
            
        System.out.println(lst.size());
    }
}
