package Constructor2;

import Constructor1.PrivateCons;
import Constructor1.ProtectedCons;

public class ProtectedCons2 {
	
	public static void main (String []args) {
		System.out.println(PrivateCons.CONSTANT);
		System.out.println(ProtectedCons.CONSTANT);
		ProtectedCons.getConstant();
		PrivateCons.getConstant();
		PrivateCons singletonIns = PrivateCons.getInstance();
		PrivateCons singletonIns2 = PrivateCons.getInstance();
		
		// Protected Constructor in different package
		//ProtectedCons protCons = new ProtectedCons();  // Compilation Error
	}

}
