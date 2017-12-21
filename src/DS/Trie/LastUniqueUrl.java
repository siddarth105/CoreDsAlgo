package DS.Trie;

/* QN :: Find last unique URL from long list of URLs in single traversal
   INPUT:
		http://www.geeksforgeeks.org
		http://quiz.geeksforgeeks.org 
		http://qa.geeksforgeeks.org 
		http://practice.geeksforgeeks.org 
		http://code.geeksforgeeks.org
		http://www.contribute.geeksforgeeks.org  
		http://quiz.geeksforgeeks.org 
		http://practice.geeksforgeeks.org 
		http://code.geeksforgeeks.org 
		http://quiz.geeksforgeeks.org 
		http://qa.geeksforgeeks.org 
		http://practice.geeksforgeeks.org

	OUTPUT:
		http://www.contribute.geeksforgeeks.org		
		
	TIME_COMPLEXITY :: O(n)	
							if hash map is used TIME_COMPLEXITY becomes O(n*n)
	SPACE_COMPLEXITY :: O(n*m)
							n -> Number of URLs
							m -> Length of the biggest URL
*/

public class LastUniqueUrl {
	
	private DLLNode head;
	private TrieNode root;
	
	public LastUniqueUrl() {
		head = new DLLNode();
		root = new TrieNode(1);
	}
	
	public void insert(String word) {
		TrieNode p = root; //Pointer to the character c
		for (int i = 0; i < word.length(); i++) {
			int index = word.charAt(i); 
			if (p.arr[index] == null) {
				TrieNode temp = new TrieNode(1);
				p.arr[index] = temp;
				p = temp;
			} else {
				p = p.arr[index];
			}
		}
		if (p.isEnd) {
			//If the node exist already in the trie, remove it from LinkedList
			if (p.llPtr != null)
				head = head.deleteNode(head, p.llPtr);
			p.llPtr = null;
		} else {
			
			p.isEnd = true;
			
			//If the node does not exist already in the trie, insert it into LinkedList
			head = head.insert(head, word);
			p.llPtr = head; // p -> last character of 'word', we make isEnd of 'p' as true and point llPtr of 'p' to the new node of DLL 
		}
	}
	
	
	public static void main (String[] args) {
		
		String urls[] = {
		        "http://www.geeksforgeeks.org",
		        "http://www.contribute.geeksforgeeks.org",
		        "http://quiz.geeksforgeeks.org",
		        "http://qa.geeksforgeeks.org",
		        "http://practice.geeksforgeeks.org",
		        "http://code.geeksforgeeks.org",
		        "http://quiz.geeksforgeeks.org",
		        "http://practice.geeksforgeeks.org",
		        "http://code.geeksforgeeks.org",
		        "http://quiz.geeksforgeeks.org",
		        "http://qa.geeksforgeeks.org",
		        "http://practice.geeksforgeeks.org"
		        };
		
		LastUniqueUrl nd = new LastUniqueUrl();
		
		for (String url : urls) {
			nd.insert(url);
		}
		
		DLLNode head = nd.head;
		while(head != null) {
			System.out.println(head.data);
			head = head.next;
		}
	}
	
	
	/* ALGORITHM :-
	 
	 * We can solve this problem in one traversal by using Trie with a Doubly Linked List (We can insert and delete in O(1) time). 
	 * The idea is to insert all URLs into the Trie one by one and check if it is duplicate or not. 
	 * To know if we have previously encountered the URL, we need to mark the last node of every URL as leaf node. 
	 * If we encounter a URL for the first time, we insert it into the doubly Linked list and maintain a pointer to that node in linked list in leaf node of the trie. 
	 * If we encounter a URL that is already in the trie and has pointer to the url in the linked list, we delete the node from the linked list and set its pointer in the trie to null. 
	 * After all URLs are processed, linked list will only contain the URLs that are distinct and the node at the beginning of the linked list will be last unique URL.
	 	
	 	*/

}
