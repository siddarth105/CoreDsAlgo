package OOPS;

import java.util.LinkedList;
import java.util.List;

public class BaseClass {
	
	public static void main (String[] args) {
		
		ImmSubClass sub = new ImmSubClass("1");
		List lst  =  new LinkedList();
		lst.add(1);
		lst.add(2);
		lst.add(3);
		
		Immutable imm = new Immutable("1", lst, sub);
		
		//Breaking Immutation
		List<Integer> lst2 = imm.getIdLst();
		lst2.add(4); // Throws UnsupportedOperationException
		
		ImmSubClass sub2 = imm.getImmSubClass();
		sub2.setName("2");
		
		List<Integer> lt = imm.getIdLst();
		for (Integer k : lt) {
			System.out.println(k);
		}
		System.out.println("Sub-Class Name :: " + imm.getImmSubClass().getName());
	}

}
