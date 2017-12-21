package CmptrNCmpble;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ChainComparator implements Comparator<Person2> {
	
	private List<Comparator<Person2>> listComparators;

	public ChainComparator(Comparator<Person2>...  comparators) {
		super();
		this.listComparators = Arrays.asList(comparators);
	}

	@Override
	public int compare(Person2 p1, Person2 p2) {
		for (Comparator<Person2> comparator: listComparators) {
			return comparator.compare(p1, p2);
		}
		return 0;
	}

}
