package Algo.LRUCache;

public interface Cacheable {
	boolean isExpired();
	String getValue();
	void resetTtl();
}
