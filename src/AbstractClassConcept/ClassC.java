package AbstractClassConcept;

public class ClassC {
	
	public static void main(String[] args) {
		
		//Private variables of ClassA is not visible and is hidden
		ClassB b = new ClassB();
		
		//ClassA cant be instantiated but can be accessed through ClassB object
		b.add();
		
		ClassA ab  = new ClassB();
		//ab -> Methods common to both A & B, methods in A
		ab.mul(); //Mul of Class b
		b.mul(); //Mul of Class b
		
		//If ClassA is not abstract, then add() cant be accessed by "ab" 
		ab.add();
		
		//OOPS concept of ABSTRACTION : Data Hiding
		InterI abs = new ClassB();
		abs.hello(); //Only the method hello() of ClassB is visible, all other methods in ClassB is hidden
	}
}
