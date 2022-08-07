package Algo.LRUCache;

public class CacheManagerTestProgram {

	public CacheManagerTestProgram() {
	}

	public static void main(String[] args) {
		CachedObject co = new CachedObject("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 1);
		CacheManager.putLruCache(co);
		Cacheable o = CacheManager.getValueFromLruCache(new CachedObject("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 1));
		if (o == null) {
			System.out.println("CacheManagerTestProgram.Main:  FAILURE!  Object not Found in cache");
		} else {
			System.out.println("CacheManagerTestProgram.Main:  SUCCESS! " + o.getValue());
		}
	}

}
