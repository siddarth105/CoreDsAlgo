package AccessModifiers;

public class StaticEg {
	
	public static int k;

	public StaticEg(int k) {
		super();
		this.k = k;
	}
	
	public void myMthd(float fl) {
		
	}
	
	/*public void myMthd() {		// Compilation Error
		
	}*/
	
	public static void myMthd(){
		
	}
	
	public static void myMthd(Integer gif){
		
	}
	
    public static void main(String... args){
    	StaticEg s1 = new StaticEg(5);
    	System.out.println("s1 :: " +s1.k);  //s1 :: 5
    	StaticEg s2 = new StaticEg(51);
    	System.out.println("s1 :: " +s1.k);  //s1 :: 51
    	System.out.println("s2 :: " +s2.k);  //s2 :: 51
    	/*How much ever object is created for the class, k will be only 1 
    	and when ever an object is created the same, the first k will be over ridden
    	Only one instance will be created for the static variable*/ 
    }
    
    public static void main2(String... args){
    	StaticEg s1 = new StaticEg(5);
    	System.out.println("s1 :: " +s1.k);  //s1 :: 5
    	StaticEg s2 = new StaticEg(52);
    	System.out.println("s1 :: " +s1.k);  //s1 :: 51
    	System.out.println("s2 :: " +s2.k);  //s2 :: 51
    	/*How much ever object is created for the class, k will be only 1 
    	and when ever an object is created the same, the first k will be over ridden
    	Only one instance will be created for the static variable*/ 
    }
}
