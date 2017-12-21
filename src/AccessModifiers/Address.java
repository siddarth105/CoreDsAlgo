package AccessModifiers;

public class Address {
	
	private Integer houseNum;
	private String houseAddr;
	
	public Address(Integer houseNum, String houseAddr) {
		super();
		this.houseNum = houseNum;
		this.houseAddr = houseAddr;
	}
	
	public Integer getHouseNum() {
		return houseNum;
	}
	public void setHouseNum(Integer houseNum) {
		this.houseNum = houseNum;
	}
	public String getHouseAddr() {
		return houseAddr;
	}
	public void setHouseAddr(String houseAddr) {
		this.houseAddr = houseAddr;
	}
	
}
