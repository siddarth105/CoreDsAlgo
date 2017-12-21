package Constructor1;

public class PrivateCons {
	
	private static PrivateCons cons;

	private PrivateCons() {
		// Prevents creating object. 
		//1.Used when all the members in the class are static
		//2.Used for creating singleton classes -> Same object for any number of request/threads
		//Eg : System.out.println has a private constructor in System class 
	}
	
	public static PrivateCons getInstance() {
		
		if (null == cons) {
			cons = new PrivateCons();
		}
		return cons;
	}
	
	public static final String CONSTANT = "CONSTANT";
	
	public static void getConstant() {
		System.out.println("PrivateCons :: getConstant => Static Method");
	}
	
	public void getGenConstant() {
		System.out.println("ProtectedCons :: getGenConstant => Static Method");
	}
	
	public static void main (String []argsS) {
		PrivateCons prCons = new PrivateCons();
	}
}
