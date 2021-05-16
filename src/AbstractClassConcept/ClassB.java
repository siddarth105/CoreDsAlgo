package AbstractClassConcept;

//A class can extend only 1 class, but can implement multiple interfaces
public class ClassB extends ClassA implements InterI, InterJ {

	public int c = 0;
	
	public void sub() {
		int a = 10; int b = 4;
		System.out.println(a-b);
	}
	
	public void mul() { //throws Exception -> Not valid Until the Super Class Method has it
		super.mul();//This is the difference bw "mul" present in Abstract class n Interface, it can be used to make default implementation if its present inside an Abstract Class
		int g = 4; int x = 8;
		System.out.println(g*x);
	}
	
	public Integer mulBy4(int var) {
		int by2Value = mulBy2(var);
		int value = by2Value * 2;
		System.out.println("ClassB :: mulBy4 :: "+ value);
		return value;
	}
	
	public Integer mulBy6(int var) {
		int by2Value = mulBy2(var);
		int value = by2Value * 3;
		System.out.println("ClassB :: mulBy6 :: "+ value);
		return value;
	}
	
	public void cancel () {
		System.out.println("Over Riding Abstract Method");
	}

	@Override
	public void hello() {
		System.out.println("Over Riding Interface'I' Method");
	}

	@Override
	public void hi() {
		System.out.println("Over Riding Interface'J' Method");
		
	}

}