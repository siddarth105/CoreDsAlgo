package PassByVal;

public class BaseClass {
	
	public static String var = "BaseClassStaticvar";
    
    static {
        //Static Block will be executed only once during Class-Load
        System.out.println("BaseClass :: Static Block");
        System.out.println("BaseClass :: Static Var :: " + var);
    }
    
    {
    	System.out.println("BaseClass :: Initializing Block");
    }
    
    public static void staticMethod() {
        
        System.out.println("BaseClass :: staticMethod ");
    }

    public BaseClass() {
        super();
        System.out.println("BaseClass :: Constructor");
    }

}
