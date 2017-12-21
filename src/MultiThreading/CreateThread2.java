package MultiThreading;

public class CreateThread2 extends Thread {
	
	public void run () {
		System.out.println("Thread");
	}
	
	public static void main(String []args) {
		CreateThread2 t = new CreateThread2();
		t.start();
	}
}
