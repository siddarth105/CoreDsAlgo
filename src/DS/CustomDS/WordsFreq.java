package DS.CustomDS;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class WordsFreq {
	
	
	private Map<String, Query> mp;
	private PriorityQueue<Query> q;
	private static int k;
	
	
	public WordsFreq () {
		mp = new LinkedHashMap<String, Query>();
		q = new PriorityQueue<Query>(k, new Comparator<Query>() {

			@Override
			public int compare(Query q1, Query q2) {
				return q1.getCount() - q2.getCount();
			}
			
		});
	}
	
	public Query insertMap(String word) {
		
		Query oldQryVal;
		
		if (mp.containsKey(word)) {
			oldQryVal = mp.get(word);
			int cnt = oldQryVal.getCount();
			oldQryVal.setCount(++cnt);
		} else {
			oldQryVal = new Query(word, 1);
		}
		
		mp.put(word, oldQryVal);
		
		return oldQryVal;
	}
	
	public void insertQueue(Query oldQryVal, Query curQryVal) {
		
		if (null != oldQryVal) {
			q.remove(oldQryVal);
		}
		
		if (q.size() >= k) {
			if (q.peek().getCount() < curQryVal.getCount()) {
				q.poll();
			} else {
				return;
			}
		} 
		q.add(curQryVal);
	}
	
	public void insert(String word){
		Query oldQryVal = mp.get(word);
		Query curQryVal = insertMap(word);
		insertQueue(oldQryVal, curQryVal);
	}
	
	public void printTopK() {
		while (!q.isEmpty()) {
			Query qry = q.poll();
			System.out.println(qry.getQuery() + " :: " + qry.getCount());
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
		
		WordsFreq w = new WordsFreq();
		
		for (String wrd : wrds) {
			w.insert(wrd);
		}
		
		w.printTopK();
	}

}
