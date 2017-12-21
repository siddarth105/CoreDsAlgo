package clone;

public class ClassB implements Cloneable {

	private ClassA a;
	private int k;

	public ClassB(ClassA a, int k) {
		this.a = a;
		this.k = k;
	}

	public ClassB(ClassB b) {
		//this.a = b.a;
		this.a = new ClassA(b.getA().getI(), b.getA().getJ());
		this.k = b.k;
	}

	public ClassA getA() {
		return a;
	}

	public int getK() {
		return k;
	}

	public void setA(ClassA a) {
		this.a = a;
	}

	public void setK(int k) {
		this.k = k;
	}
	
	protected Object clone() throws CloneNotSupportedException {
		ClassB b = (ClassB) super.clone();
		// Deep Clone
		ClassA a = (ClassA) b.getA().clone();
		b.setA(a);
		return b;
	}
	
}
