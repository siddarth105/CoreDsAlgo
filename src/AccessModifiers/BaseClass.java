package AccessModifiers;

public class BaseClass {
	
	public static void main(String[] args) {
		
		Address a1 = new Address(1, "a");
		Immutable im = new Immutable(101, "sid", a1);
		
		System.out.println("House-Number of im :: " + im.getAddr().getHouseNum());
		
		Address a3 = im.getAddr();
		a3.setHouseNum(5);
		
		System.out.println("House-Number of im :: " + im.getAddr().getHouseNum());
	}

}
