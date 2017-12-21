package Collections;

public class SinglyLinkedListImpl {
	private Node head;
    private Node tail;
     
    public void add(Integer item){
         
        Node nd = new Node();
        nd.setItem(item);
        System.out.println("Adding: "+item);
         //check if the list is empty
        if(head == null){
            //since there is only one element, both head and
            //tail points to the same object.
            head = nd;
            tail = nd;
        } else {
            //set current tail next link to new node
            tail.setNext(nd);
            //set tail as newly created node
            tail = nd;
        }
    }
     
    /*public void addAfter(T element, T after){
         
        Node tmp = head;
        Node refNode = null;
        System.out.println("Traversing to all nodes..");
        *//**
         * Traverse till given element
         *//*
        while(true){
            if(tmp == null){
                break;
            }
            if(tmp.compareTo(after) == 0){
                //found the target node, add after this node
                refNode = tmp;
                break;
            }
            tmp = tmp.getNextRef();
        }
        if(refNode != null){
            //add element after the target node
            Node nd = new Node();
            nd.setValue(element);
            nd.setNextRef(tmp.getNextRef());
            if(tmp == tail){
                tail = nd;
            }
            tmp.setNextRef(nd);
             
        } else {
            System.out.println("Unable to find the given element...");
        }
    }
     
    public void deleteFront(){
         
        if(head == null){
            System.out.println("Underflow...");
        }
        Node tmp = head;
        head = tmp.getNextRef();
        if(head == null){
            tail = null;
        }
        System.out.println("Deleted: "+tmp.getValue());
    }
     
    public void deleteAfter(T after){
         
        Node tmp = head;
        Node refNode = null;
        System.out.println("Traversing to all nodes..");
        *//**
         * Traverse till given element
         *//*
        while(true){
            if(tmp == null){
                break;
            }
            if(tmp.compareTo(after) == 0){
                //found the target node, add after this node
                refNode = tmp;
                break;
            }
            tmp = tmp.getNextRef();
        }
        if(refNode != null){
            tmp = refNode.getNextRef();
            refNode.setNextRef(tmp.getNextRef());
            if(refNode.getNextRef() == null){
                tail = refNode;
            }
            System.out.println("Deleted: "+tmp.getValue());
        } else {
            System.out.println("Unable to find the given element...");
        }
    }*/
     
    public void traverse(){
         
        Node tmp = head;
        while(true){
            if(tmp == null){
                break;
            }
            System.out.println(tmp.getItem());
            tmp = tmp.getNext();
        }
    }
     
    public static void main(String a[]){
        SinglyLinkedListImpl sl = new SinglyLinkedListImpl();
        sl.add(3);
        sl.add(32);
        sl.add(54);
        sl.add(89);
        //sl.addAfter(76, 54);
        //sl.deleteFront();
        //sl.deleteAfter(76);
        sl.traverse();
         
    }


}
