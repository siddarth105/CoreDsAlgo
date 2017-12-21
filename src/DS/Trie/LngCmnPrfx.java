package DS.Trie;

/*	TIME_COMPLEXITY :: O(MN) :: O(20)
    SPACE_COMPLEXITY :: O(26*M*N)
	M -> Length of the largest string -> 5
	N -> Number of Strings  -> 4	*/
public class LngCmnPrfx {

	static int index = 0;
	
	public static String walkTrie(TrieNode nd) {
		TrieNode p = nd;
		StringBuffer prefix = new StringBuffer();

		while (countChildren(p) == 1 && p.isEnd == false) {
			p = p.arr[index];
			char c = (char) ('a' + index);
			prefix.append(c);
		}
		return prefix.toString();
	}
	
	private static int countChildren(TrieNode node) {
		int count = 0;
		for (int i = 0; i < 26; i++) {
			if (null != node.arr[i]) {
				count++;
				index = i;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("the");
		trie.insert("th");
		trie.insert("their");
		trie.insert("thy");
		String prfx = walkTrie(trie.getRoot());
		System.out.println("Longest Common Prefix is :: " + prfx);
	}
}
