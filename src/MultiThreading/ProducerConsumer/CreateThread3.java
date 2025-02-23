package MultiThreading;

public class CreateThread3 implements Runnable {
	
	public void run () {
		System.out.println("Thread");
	}
	
	public static void main(String []args) {
		Thread t = new Thread(new CreateThread2());
		t.start();
	}

}
