package CmptrNCmpble;

import java.util.Comparator;

import Pbm.EltFrqSort;
import Pbm.EltFrqSort.Elt;

public class EltCountComp implements Comparator<EltFrqSort.Elt>{

	@Override
	public int compare(Elt e1, Elt e2) {
		 if(e1.count < e2.count){
			 return -1; 
		 }
		return 1;
	}
}
