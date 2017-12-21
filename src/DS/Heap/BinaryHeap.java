package DS.Heap;

import java.util.ArrayList;

import DS.Trie.MinHeapNode;
import DS.Trie.TrieNode;

//Min-Heap
public class BinaryHeap<T extends Comparable<T>> {
    
	public ArrayList<T> list;

    public BinaryHeap() {
        this(0);
    }

    public BinaryHeap(int size) {
        list = new ArrayList<T>(size);
    }

    public BinaryHeap(ArrayList<T> items) {
        list = items;
        buildHeap();
    }

    /* O(log n) */
    public void insert(T item) {
        int i = list.size();
        list.add(item);
        int parent = parent(i);
        while (parent != -1 && list.get(i).compareTo(list.get(parent)) < 0) {
            swap(i, parent);
            i = parent;
            parent = parent(i);
        }
    }

    /* O(log n) */
    public T extractMin() {
        if (list.size() == 0) {
            return null;
        }
        if (list.size() == 1) {
            return list.remove(0);
        }
        T min = list.get(0);
        T last = list.remove(list.size() - 1);
        list.set(0, last);
        heapify(0);
        return min;
    }

    /*O(1)*/
    public T min() {
        if (list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    public void clear() {
        list.clear();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }

    public void print() {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ", ");
        }
        System.out.println();
    }

    /* O(n)*/
    public void buildHeap() {
        for (int i = (int)(list.size() / 2); i >= 0; i--) {
            heapify(i);
        }
    }

    public void heapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < list.size() && list.get(l).compareTo(list.get(i)) < 0) {
            smallest = l;
        }
        if (r < list.size() && list.get(r).compareTo(list.get(smallest)) < 0) {
            smallest = r;
        }
        if (smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }

    private void swap(int i1, int i2) {
        T temp = list.get(i1);
        list.set(i1, list.get(i2));
        list.set(i2, temp);
    }

    private int parent(int i) {
        if (i == 0) {
            return -1;
        }
        return (i - 1) / 2;
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }
    
    public static void main(String[] args) {
    	BinaryHeap<Integer> hp = new BinaryHeap<Integer>();
    	hp.insert(10);
    	hp.insert(4);
    	hp.insert(3);
    	hp.insert(2);
    	hp.insert(5);
    	hp.insert(6);
    	System.out.println(hp.min());
    }
    
    
    /********************************************************************************************************/
    
    public void insert(T item, int z) {
        int i = list.size();
        list.add(item);
        int parent = parent(i);
        while (parent != -1 && list.get(i).compareTo(list.get(parent)) < 0) {
            swap2(i, parent);
            i = parent;
            parent = parent(i);
        }
    }
    
    public void buildHeap(int z) {
        for (int i = (int)(list.size() / 2); i >= 0; i--) {
            heapify(i, 1);
        }
    }
    
    public void heapify(int i, int z) {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < list.size() && list.get(l).compareTo(list.get(i)) < 0) {
            smallest = l;
        }
        if (r < list.size() && list.get(r).compareTo(list.get(smallest)) < 0) {
            smallest = r;
        }
        if (smallest != i) {
            swap2(i, smallest);
            heapify(smallest, 1);
        }
    }
    
    private void swap2(int i1, int i2) {
    	
    	//Swap the indxMinHp value inside TrieNode
    	MinHeapNode mnHP1 = (MinHeapNode) list.get(i1);
    	MinHeapNode mnHp2 = (MinHeapNode) list.get(i2);
    	int tempIndx = mnHP1.getTrNode().getIndxMinHp();
    	mnHP1.getTrNode().setIndxMinHp(mnHp2.getTrNode().getIndxMinHp());
    	mnHp2.getTrNode().setIndxMinHp(tempIndx);
    	
        T temp = list.get(i1);
        list.set(i1, list.get(i2));
        list.set(i2, temp);
    }
    
    /********************************************************************************************************/
}