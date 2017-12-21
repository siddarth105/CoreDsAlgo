package Constructor1;

public class BaseClass {
	
	
	public static void main (String []args) {
		
		System.out.println(PrivateCons.CONSTANT);
		PrivateCons.getConstant();
		
		//PrivateCons pCons = new PrivateCons(); // Compilation Error
		ProtectedCons protCons = new ProtectedCons(); // Protected Constructor in same package
	}
}
