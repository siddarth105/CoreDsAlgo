package Algo.Backtracking;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An implicit immutable collection of all permutations of a string with an 
 * iterator over the permutations.<p>  implements Iterable&ltString&gt
 * @see #RecurLessPermutation(String)
 */
public class RecurLessPermutation implements Iterable<String> {

	// could implement Collection<String> but it's immutable, so most methods are essentially vacuous
    protected final String string;

    /**
     * Creates an implicit Iterable collection of all permutations of a string
     * @param string  String to be permuted
     * @see Iterable
     * @see #iterator
     */
    public RecurLessPermutation(String string) {
        this.string = string;
    }

    /**
     * Constructs and sequentially returns the permutation values 
     */
    @Override
    public Iterator<String> iterator() {

        return new Iterator<String>() {

            char[] array = string.toCharArray(); 
            int length = string.length();
            int[] index = (length == 0) ? null : new int[length];

            @Override
            public boolean hasNext() {
                return index != null;
            }

            @Override
            public String next() {

                if (index == null) throw new NoSuchElementException();
                
                for (int i = 1; i < length; i++) {
                    char swap = array[i];
                    System.arraycopy(array, 0, array, 1, i);
                    array[0] = swap;
                    //making all 0 for every 2nd iteration
                    for (int j = 1 ; j < i; ++j) {
                        index[j] = 0;
                    }
                    if (++index[i] <= i) {
                        //Regular-Exit :: It will be executed for every element except the last element
                        return  new String(array);
                    }
                    index[i] = 0;                    
                }
                
                //Final-Exit :: It will be executed only on the last element
                index = null;
                return new String(array);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException(); 
            }
        };
    }
    
    
    public static void main (String[] args) {
		
		RecurLessPermutation rs =  new RecurLessPermutation("ABC");
		Iterator<String> i = rs.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
		
	}

}
