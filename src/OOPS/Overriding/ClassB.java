package OOPS.Overriding;

public class ClassB extends ClassA {

	public ClassB mthd(ClassA a) {
		System.out.println("ClassA");
		return null;
	}

	public ClassB mthd(ClassB b) {
		System.out.println("ClassB");
		return null;
	}

	public static void main(String[] args) {
		ClassA ab = new ClassB();
		ClassB b = new ClassB();
		ClassA a = new ClassA();
		ab.mthd(b);
	}
}
