package Constructor2;

public class BaseClass2 {
	
	public BaseClass2 (int k) {
		System.out.println("Inside BaseClass2 :: Single Parameter Constructor -> k = " +k);
	}
	
	public BaseClass2 (int k, int j) {
		System.out.println("Inside BaseClass2 :: Double Parameter Constructor -> k = "  +k + " j = "+j);
	}
	
	/*Compilation Error :-
	Subclass should also have the constructor of the same type, with the super pointing to the Base
	when there is no default constructor in BaseClass2*/
	public BaseClass2 () {
		System.out.println("Inside BaseClass2 :: Default Constructor");
	}

}
