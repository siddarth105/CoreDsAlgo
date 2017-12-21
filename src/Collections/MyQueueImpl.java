package Collections;

public class MyQueueImpl {
	
	private int capacity;
    int queueArr[];
    int front = 0;
    int rear = -1;
    int currentSize = 0;
    
    public MyQueueImpl(int queueSize){
        this.capacity = queueSize;
        queueArr = new int[this.capacity];
    }
    
    public boolean isQueueFull(){
        boolean status = false;
        if (currentSize == capacity){
            status = true;
        }
        return status;
    }
    
    public boolean isQueueEmpty(){
        boolean status = false;
        if (currentSize == 0){
            status = true;
        }
        return status;
    }
    
    public int[] enqueue(int item) {
        if (isQueueFull()) {
            System.out.println("Overflow ! Unable to add element: "+item);
         } else {
            rear++;
            if (currentSize == 0) {
                rear = 0;
                front = 0;
            }
            queueArr[rear] = item;
            currentSize ++;
        }
        return queueArr;
    }
    
    public int[] dequeue() {
        if (isQueueEmpty()) {
            System.out.println("Underflow ! Unable to remove element from Queue");
            return queueArr;
        } else {
            front++;
            rear = --currentSize;
            for (int k=0; k<currentSize; k++) {
                int tmp = queueArr[front];
                queueArr[k] = tmp;
                queueArr[front] = 0;
                front++;
            }
            if(currentSize == 1) {
                rear = 0;
            } else if (currentSize == 0) {
                queueArr = new int[this.capacity]; 
            }
            front = 0;
            return queueArr;
        }
    }
    
    public static void main(String a[]){
        
        int queueArr[];
        MyQueueImpl queue = new MyQueueImpl(4);
        queueArr = queue.enqueue(4);
        queueArr = queue.dequeue();
        queueArr = queue.enqueue(56);
        queueArr = queue.enqueue(2);
        queueArr = queue.enqueue(67);
        queueArr = queue.enqueue(100);
        queueArr = queue.enqueue(101);
        queueArr = queue.dequeue();
        queueArr = queue.dequeue();
        queueArr = queue.dequeue();
        queueArr = queue.dequeue();
        queueArr = queue.dequeue();
        queueArr = queue.enqueue(24);
        queueArr = queue.dequeue();
        queueArr = queue.enqueue(98);
        queueArr = queue.enqueue(45);
        queueArr = queue.enqueue(23);
        queueArr = queue.enqueue(435);
    }

}
