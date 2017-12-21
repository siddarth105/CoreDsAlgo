package OOPS.Overloading;

public class ClassB extends ClassA {

	public void mthd(ClassA a) {
		System.out.println("ClassA");
	}

	public void mthd(ClassB b) {
		System.out.println("ClassB");
	}

	public static void main(String[] args) {
		ClassA ab = new ClassB();
		ClassB b = new ClassB();
		ClassA a = new ClassA();
		ab.mthd(b); // Covariant Overloading -> Method is declared at Compile
					// Time
		// b.mthd(b); // Overloading
	}
}
