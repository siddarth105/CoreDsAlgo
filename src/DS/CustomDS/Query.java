package DS.CustomDS;

public class Query {
	
	private String query;
	private int count;
	
	public Query(String query, int count) {
		super();
		this.query = query;
		this.count = count;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
}
