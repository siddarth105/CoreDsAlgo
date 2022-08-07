package Algo.LRUCache;

import java.util.Calendar;
import java.util.Date;

public class CachedObject implements Cacheable {

	public String object = null;
	private int minutesToLive;
	private Date dateofExpiration = null;
	

	public CachedObject(String obj, int minutesToLive) {
		this.object = obj;
		this.minutesToLive =  minutesToLive;
		resetTtl();
	}

	public boolean isExpired() {
		// Remember if the minutes to live is zero then it lives forever!
		if (dateofExpiration != null) {
			// date of expiration is compared.
			if (dateofExpiration.before(new Date())) {
				System.out.println("CachedResultSet.isExpired:  Expired from Cache! EXPIRE TIME: "
						+ dateofExpiration.toString() + " CURRENT TIME: " + (new Date()).toString());
				return true;
			} else {
				System.out.println("CachedResultSet.isExpired: Not expired from Cache!");
				return false;
			}
		} else {
			// This means it lives forever!
			return false;
		}
	}
	
	public void resetTtl() {
		if (minutesToLive != 0) {
			dateofExpiration = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(dateofExpiration);
			cal.add(Calendar.MINUTE, minutesToLive);
			dateofExpiration = cal.getTime();
		}
	}
	
	public String getValue() {
		return this.object;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((object == null) ? 0 : object.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CachedObject other = (CachedObject) obj;
		if (object == null) {
			if (other.object != null)
				return false;
		} else if (!object.equals(other.object))
			return false;
		return true;
	}
}
