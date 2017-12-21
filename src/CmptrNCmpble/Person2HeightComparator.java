package CmptrNCmpble;

import java.util.Comparator;

public class Person2HeightComparator implements Comparator<Person2> {

	@Override
	public int compare(Person2 per1, Person2 per2) {
		
		if (per1.getHieght() > per2.getHieght()) {
			return 1;
		} else if (per1.getHieght() < per2.getHieght()) {
			return -1;
		} else {
			return 0;
		}
	}

}
