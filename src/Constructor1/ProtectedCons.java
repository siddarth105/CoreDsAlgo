package Constructor1;

public class ProtectedCons {

	protected ProtectedCons() {
		super();
	}
	
	public static final String CONSTANT = "CONSTANT";
	
	public static void getConstant() {
		System.out.println("ProtectedCons :: getConstant => Static Method");
	}
	
	public void getGenConstant() {
		System.out.println("ProtectedCons :: getGenConstant => Static Method");
	}

}
