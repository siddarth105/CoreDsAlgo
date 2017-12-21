package DS.Trie;

public class Trie {

	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}
	
	public TrieNode getRoot() {
		return root;
	}
	
	// TIME_COMPLEXITY :: O(N), N -> length of the search string
	public void insert(String word) {
		TrieNode p = root; //Pointer to the character c
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			int index = c - 'a'; //ASCII value of a = 97
			if (p.arr[index] == null) {
				TrieNode temp = new TrieNode();
				p.arr[index] = temp;
				p = temp;
			} else {
				p = p.arr[index];
			}
		}
		p.isEnd = true;
	}

	// Returns if the word is in the trie.
	public boolean search(String word) {
		TrieNode p = searchNode(word);
		if (p == null) {
			return false;
		} else {
			if (p.isEnd)
				return true;
		}

		return false;
	}

	// Returns if there is any word in the trie that starts with the given prefix.
	public boolean startsWith(String prefix) {
		TrieNode p = searchNode(prefix);
		if (p == null) {
			return false;
		} else {
			return true;
		}
	}

	// TIME_COMPLEXITY :: O(N), N -> length of the search string 
	public TrieNode searchNode(String s) {
		TrieNode p = root;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int index = c - 'a';
			if (p.arr[index] != null) {
				p = p.arr[index];
			} else {
				return null;
			}
		}

		if (p == root)
			return null;

		return p;
	}
}
