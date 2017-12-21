package CmptrNCmpble;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PersonImpl {
	
	
	public static void main(String []args) {
		
		List<Person> perList = new ArrayList<Person>();
		perList.add(new Person("Sid", 25, 172));
		perList.add(new Person("Ravi", 32, 176));
		perList.add(new Person("Sathesh", 28, 178));
		Collections.sort(perList);
		for (Person p : perList) {
			System.out.println("Name :: " + p.getName());
		}
	}

}
