package CmptrNCmpble;

import java.util.Comparator;
import Pbm.EltFrqSort;
import Pbm.EltFrqSort.Elt;

public class EltValComp implements Comparator<EltFrqSort.Elt>{

	@Override
	public int compare(Elt e1, Elt e2) {
		 if(e1.val < e2.val){
			 return -1; 
		 }
		return 1;
	}

}
