package clone;

public class ClassA  implements Cloneable {
	
	private int i;
	private int j;
	
	public ClassA(int i, int j) {
		this.i = i;
		this.j = j;
	}

	public int getI() {
		return i;
	}

	public int getJ() {
		return j;
	}

	public void setI(int i) {
		this.i = i;
	}

	public void setJ(int j) {
		this.j = j;
	}
	
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
}
