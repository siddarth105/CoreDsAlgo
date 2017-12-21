package MultiThreading;

public class Common {
	int x;

	boolean flag = true;
	// if flag is true producer thread has to produce
	// if flag is false consumer thread has to produce

	synchronized public void produce(int i) {
		
		System.out.println(Thread.currentThread().getName());

		if (flag) {
			x = i;
			System.out.println("producer thread has produced " + i);
			flag = false;
			notify();
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	synchronized public int consume() {
		System.out.println(Thread.currentThread().getName());
		if (flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		flag = true;
		notify();
		return x;
	}
	 
}
