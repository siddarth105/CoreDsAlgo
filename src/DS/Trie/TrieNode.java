package DS.Trie;

public class TrieNode {
	
	TrieNode[] arr;
    boolean isEnd;
    
    public TrieNode() {
        this.arr = new TrieNode[26];
    }
    
    /****************************************************************************************************/
    
    DLLNode llPtr;
    public TrieNode(int k) {
        this.arr = new TrieNode[256];
    }
    
    /****************************************************************************************************/
    
    int freq;
    int indxMinHp;
    public TrieNode(int k, int j) {
        this.arr = new TrieNode[26];
        this.isEnd = false;
        this.indxMinHp = -1;
        this.freq = 0;
    }
    
    /****************************************************************************************************/
    
	public int getIndxMinHp() {
		return indxMinHp;
	}
	
	public void setIndxMinHp(int indxMinHp) {
		this.indxMinHp = indxMinHp;
	}
    
}