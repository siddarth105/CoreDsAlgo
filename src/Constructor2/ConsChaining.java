package Constructor2;

public class ConsChaining {
	
	public ConsChaining() {
		System.out.println("0");
	}

	public ConsChaining(int i) {
		this();
		System.out.println("1");
	}

	public ConsChaining(int i, int j) {
		this(1);
		System.out.println("2");
	}

	public static void main(String[] args) {
		ConsChaining c = new ConsChaining(1, 2);
	}

}
