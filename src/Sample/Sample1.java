package Sample;

public class Sample1 {
	
	public static void main(String []args){
		/*Queue q = new ArrayDeque();
		q.add(1);
		q.add(2);
		System.out.println(q.remove());
		
		Map m1 =  new HashMap();
		m1.put(1, 1);
		
		String s= "1233";
		Integer k = Integer.parseInt("1233");
		System.out.println(k);*/
		
		String Number = "1234*";
		String NumberPattern = "[0-9]+";
		
		if (Number.matches(NumberPattern)) { 
		    //code for number
			System.out.println("Number");
		} else {
			System.out.println("Not a number");
		}
	}

}
