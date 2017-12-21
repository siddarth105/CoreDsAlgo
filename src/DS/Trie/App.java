package DS.Trie;

public class App {

	public static void main(String[] args) {
		Trie trie = new Trie();
		
	 /*	TIME_COMPLEXITY :: O(MN) :: O(20)
	 	M -> Length of the largest string -> 5
	 	N -> Number of Strings  -> 4	*/
		trie.insert("the");
		trie.insert("th");
		trie.insert("their");
		trie.insert("thy");
		
		String startWith = "thei";
		if (trie.startsWith(startWith)){
			System.out.println("Trie has a word that starts with :: " + startWith);
		} else {
			System.out.println("Trie has a word that starts with :: " + startWith);
		}
		
		String srchWord = "they";
		if (trie.search(srchWord)){
			System.out.println(srchWord + " :: is present in Trie");
		} else {
			System.out.println(srchWord + " :: is not present in Trie");
		}
	}
}
