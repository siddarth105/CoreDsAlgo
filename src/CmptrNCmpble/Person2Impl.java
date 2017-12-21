package CmptrNCmpble;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person2Impl {
	
public static void main(String []args) {
		
		List<Person2> perList = new ArrayList<Person2>();
		perList.add(new Person2("Sid", 25, 172));
		perList.add(new Person2("Ravi", 32, 176));
		perList.add(new Person2("Sathesh", 28, 178));
		//Collections.sort(perList, new Person2AgeComparator());
		Collections.sort(perList, new ChainComparator(new Person2AgeComparator(), new Person2HeightComparator()));
		for (Person2 p : perList) {
			System.out.println("Name :: " + p.getName() + " Age :: " + p.getAge() + " Height :: " + p.getHieght());
		}
	}

}
