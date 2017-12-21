package AccessModifiers;

public final class Immutable {
	
	private final Integer empId;
	private final String empName;
	//Mutable object
	private final Address addr;
	
	public Immutable(Integer empId, String empName, Address addr) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.addr = addr;
	}

	public Integer getEmpId() {
		return empId;
	}

	public String getEmpName() {
		return empName;
	}

	public Address getAddr() {
		//Defensive Approach - Return a new Address copying the actual values from the old copy
		//return new Address(addr.getHouseNum(), addr.getHouseAddr());
		return addr;
	}
	
}
