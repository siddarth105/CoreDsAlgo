package PassByVal;

public class StringConcept {
	
	
	public static void main(String []args) {
		String a = "Java"; //String Literal
		String b = "Java";
		System.out.println(a == b); // True because "==" compares for the object reference and since both a and b correspond to the same object in the String Pool, it is true
		
		String c = new String("Java"); //String Object
		String d = new String("Java");
		System.out.println(c == d);  // False because c and d are different objects although they have the same value
	}

}
