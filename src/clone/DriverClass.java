package clone;

public class DriverClass {
	
	public static void main (String[] args) throws CloneNotSupportedException {
		
		ClassA a = new ClassA(1, 2);
		ClassB b1 = new ClassB(a, 3);
		
		System.out.println("b1 -> i :: " + b1.getA().getI() + ", j :: " + b1.getA().getJ() + ", K :: " + b1.getK());
		
		ClassB b2  = (ClassB) b1.clone();
		System.out.println("b2 ->i :: " + b2.getA().getI() + ", j :: " + b2.getA().getJ() + ", K :: " + b2.getK());
		
		b2.getA().setI(11);
		
		System.out.println("Deep Copy Using Clonable ");
		System.out.println("b1 -> i :: " + b1.getA().getI() + ", j :: " + b1.getA().getJ() + ", K :: " + b1.getK());
		System.out.println("b2 -> i :: " + b2.getA().getI() + ", j :: " + b2.getA().getJ() + ", K :: " + b2.getK());
		
		System.out.println("Deep Copy using Copy Constructor");
		ClassB b3 = new ClassB(b1);
		System.out.println("b1 -> i :: " + b1.getA().getI() + ", j :: " + b1.getA().getJ() + ", K :: " + b1.getK());
		System.out.println("b3 -> i :: " + b3.getA().getI() + ", j :: " + b3.getA().getJ() + ", K :: " + b3.getK());
		
		b3.getA().setI(10);
		
		System.out.println("After Changing b3.a ");
		System.out.println("b1 -> i :: " + b1.getA().getI() + ", j :: " + b1.getA().getJ() + ", K :: " + b1.getK());
		System.out.println("b3 -> i :: " + b3.getA().getI() + ", j :: " + b3.getA().getJ() + ", K :: " + b3.getK());
		
	}

}
