package Constructor2;

public class CopyCons {
	
	private String st;
	private Integer in;

	public CopyCons(CopyCons cc) {
		this.st = cc.st;
		this.in = cc.in;
	}

	public CopyCons(String st, Integer in) {
		this.st = st;
		this.in = in;
	}
	
}
