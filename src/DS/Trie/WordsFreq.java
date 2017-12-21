package DS.Trie;

import DS.Heap.BinaryHeap;

//Not working
//http://www.geeksforgeeks.org/find-the-k-most-frequent-words-from-a-file/
public class WordsFreq {
	
	private TrieNode root;
	private BinaryHeap<MinHeapNode> h;
	static int k;
	
	public WordsFreq() {
		root =  new TrieNode(1, 2);
		h = new BinaryHeap<MinHeapNode>(k);
	}
	
	public void insertMinHeap(TrieNode p, String word) {
		
		MinHeapNode hNd = null;
		
		if (p.indxMinHp != -1 && p.indxMinHp < k) {
			
			// Case 1: the word is already present in minHeap
			hNd = h.list.get(p.indxMinHp);
			hNd.freq ++;
			h.heapify(p.indxMinHp, 1);  //Have to change the indxMinHp
		} else if (h.list.size() < k) {
			
			// Case 2: Word is not present and heap is not full
			hNd = new MinHeapNode(p, p.freq, word);
			p.indxMinHp = h.list.size() - 1;
			h.insert(hNd, 1);
			h.buildHeap(1);
		} else if (p.freq > h.min().freq) {
			
			// Case 3: Word is not present and heap is full. And frequency of word
		    // is more than root. Replace root with new word
			hNd = new MinHeapNode(p, p.freq, word);
			h.list.remove(0);
			h.list.add(0, hNd);
			h.heapify(0, 1);
		}
		
	}
	
	
	public void insert(String word) {
		TrieNode p = root; //Pointer to the character c
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			int index = c - 'a'; //ASCII value of a = 97
			if (p.arr[index] == null) {
				TrieNode temp = new TrieNode(1, 2);
				p.arr[index] = temp;
				p = temp;
			} else {
				p = p.arr[index];
			}
		}
		if(p.isEnd) {
			p.freq ++;
		} else {
			p.freq = 1;
			p.isEnd = true;
		}
		
		insertMinHeap(p, word);
	}
	
	
	public static void printData(WordsFreq nd){
		for (MinHeapNode hp : nd.h.list) {
			System.out.print(hp.word + " :: " + hp.freq);
			System.out.println();
		}
	}
	
	
	public static void main(String[] args) {
		String wrds[] = {
		        "this", "the", "them", "these", "that", "they", "these", "these",
		        "these", "this", "this", "this", "this", "them", "them", "them", 
		        "them", "them", "the", "the", "the", "the", "the", "the", "that",
		        "that", "they"
		        };
		k = 3;
		WordsFreq nd =  new WordsFreq();
		
		for (String wrd : wrds) {
			nd.insert(wrd);
		}
		
		printData(nd);
	}
}
		