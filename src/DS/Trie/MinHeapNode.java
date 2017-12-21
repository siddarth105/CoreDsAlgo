package DS.Trie;

public class MinHeapNode implements Comparable<MinHeapNode> {
	
	TrieNode trNode;
	int freq ;
	String word;
	
	public MinHeapNode(){
		
	}
	
	public MinHeapNode(TrieNode trNode, int freq, String word) {
		this.trNode = trNode;
		this.freq = freq;
		this.word = word;
	}

	@Override
	public int compareTo(MinHeapNode nd) {
		
		if(this.freq > nd.freq) {
			return 1;
		} else {
			return -1;
		} 
	}

	public TrieNode getTrNode() {
		return trNode;
	}

	public int getFreq() {
		return freq;
	}

	public String getWord() {
		return word;
	}
	
}
