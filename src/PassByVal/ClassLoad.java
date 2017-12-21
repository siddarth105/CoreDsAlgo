package PassByVal;

@SuppressWarnings({ "rawtypes", "unused" })
public class ClassLoad {
	
	 //Static Block will be executed only once during Class-Load
    static {
        System.out.println("------------Loading ClassLoad------------ \n");
        System.out.println("ClassLoad :: Static Block");
    }
    
    {
    	System.out.println("ClassLoad :: Initializing Block");
    }

    public ClassLoad() {
        super();
        System.out.println("ClassLoad :: Constructor");
    }
    
	public static void main (String []args) {
        try {
            
            System.out.println("\n ------------Loading BaseClass------------ \n");
            
            Class c =  Class.forName("PassByVal.BaseClass");
            
            System.out.println("\n ------------Initializing BaseClass------------ \n");
            
            BaseClass b =  (BaseClass) c.newInstance();
            
            System.out.println("\n ------------Loading BaseClass Again------------ \n");
            
            Class d =  Class.forName("PassByVal.BaseClass");
            
            System.out.println("\n ------------Done Loading BaseClass Again------------ \n");
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
