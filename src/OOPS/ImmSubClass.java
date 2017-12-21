package OOPS;

public class ImmSubClass {
	
	private String name;
	
	public ImmSubClass(String name) {
		this.name = name;
	}
	
	public ImmSubClass(ImmSubClass imSub) {
		this.name = imSub.name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
