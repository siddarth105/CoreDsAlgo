package PassByVal;

public class Sample2 {
	
	
	public static void main(String args[]) {
	       Car car = new Car("BMW");
	       System.out.println("Brand of Car Inside main() before: "+ car.brand);
	       printBrand(car);
	       System.out.println("Brand of Car Inside main()after: "+ car.brand);
	    }
	  
	    public static void printBrand(Car car){
	        car.brand = "Maruti";
	        System.out.println("Brand of Car Inside printBrand(): "+car.brand);
	    }
	  
	    private static class Car{
	        private String brand;
	      
	        public Car(String brand){
	            this.brand = brand;
	        }

	    }

}
