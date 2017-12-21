package AbstractClassConcept;


public abstract class ClassA {
	public int k = 0;
	private int l = 1;
	
	//Abstract class can have constructor, to initialise the variables present in it
	
	public void add() {
		int a =1; int b=3;
		System.out.println(a+b);
	}
	public void mul(){
		int g = 2; int x = 6;
		System.out.println(g*x);
	}
	public int getL() {
		return l;
	}
	
	//Abstract Method
	public abstract void cancel();
	
	
	/*public void setL(int l) {
		this.l = l;
	}*/
}
