package OOPS;

import java.util.Collections;
import java.util.List;

public final class Immutable {
	
	private final String name;
	private final List<Integer> idLst;
	private final ImmSubClass immSubClass;
	
	public Immutable(String name, List<Integer> idLst, ImmSubClass immSubClass) {
		this.name = name;
		this.idLst = idLst;
		this.immSubClass = immSubClass;
	}

	public String getName() {
		return name;
	}

	public List<Integer> getIdLst() {
		//return Collections.unmodifiableList(idLst);
		return idLst;
	}

	public ImmSubClass getImmSubClass() {
		//return new ImmSubClass(immSubClass);  // Defensive Approach
		return immSubClass;
	}
	
}
