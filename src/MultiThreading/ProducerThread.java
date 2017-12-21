package MultiThreading;

public class ProducerThread extends Thread {
	
	Common c;

	ProducerThread(Common c) {
		this.c = c;
	}

	public void run() {
		int i = 0;
		while (true) {

			i++;
			c.produce(i);

			try {
				Thread.sleep(600);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
