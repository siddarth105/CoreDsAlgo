package Algo.LRUCache;

public class DllNode {
	
	private String value;
	
	public DllNode prev;
	public DllNode next;
	
	public DllNode(String value) {
		this.value = value;
	} 
}
