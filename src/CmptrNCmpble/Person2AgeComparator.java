package CmptrNCmpble;

import java.util.Comparator;

public class Person2AgeComparator implements Comparator<Person2> {

	@Override
	public int compare(Person2 per1, Person2 per2) {
		
		if (per1.getAge() > per2.getAge()) {
			return 1;
		} else if (per1.getAge() < per2.getAge()) {
			return -1;
		} else {
			return 0;
		}
	}

}
