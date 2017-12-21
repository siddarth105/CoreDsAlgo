package PassByVal;

public class CallByRefrVal {
	
	public class Number {
		int x;
	}

	public static void main (String[] args) {
		
		CallByRefrVal s = new CallByRefrVal();
		Number num = s.new Number();
		num.x = 10;
		System.out.println("B4 methd :- " + num.x);
		s.methd(num);
		System.out.println("After methd :- " + num.x);
		
		StringBuffer sb = new StringBuffer();
		sb.append("123");
		System.out.println("B4 methd :- " + sb.toString());
		s.methd(sb);
		System.out.println("B4 methd :- " + sb.toString());
	}
	
	public void methd(Number num) {
		++num.x;
		num = new Number();
		num.x = 2;
		System.out.println("Inside method :- " + num.x);
	}
	
	public void methd(StringBuffer sb) {
		sb.append("4");
		sb = new StringBuffer("abc");
		System.out.println("B4 methd :- " + sb.toString());
	}

}
