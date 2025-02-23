package MultiThreading;

public class CreateThread1 {
	
	public static void main (String []args) {
		
		Thread t = new Thread(){
			public void run() {
				System.out.println("Thread");
			}
		};
		t.start();
	}

}
