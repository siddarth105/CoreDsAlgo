package AccessModifiers;

public class FinalEg {
	public final int k;

	public FinalEg(int k) {
		super();
		//Final variables can be initialised only inside the constructor
		this.k = k;
	}
	
	// Error :: Can not modify a final variable once initialized
	/*public void modifyK(){
		this.k = 70;
	}*/
	
	public static void main(String... args){
    	FinalEg s1 = new FinalEg(5);
    	FinalEg s2 = new FinalEg(51);
    	System.out.println("s1 :: " +s1.k);  //s1 :: 5
    	System.out.println("s2 :: " +s2.k);  //s2 :: 51
    }
}
