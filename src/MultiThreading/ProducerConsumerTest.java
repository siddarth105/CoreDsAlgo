package MultiThreading;

public class ProducerConsumerTest {
	
	public static void main(String args[]){
        Common c= new Common();
        ProducerThread pt=new ProducerThread(c);
        ConsumerThread ct= new ConsumerThread(c);
        pt.start();
        ct.start();
    }
	
}
