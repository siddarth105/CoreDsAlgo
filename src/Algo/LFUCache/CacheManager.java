package Algo.LFUCache;

import java.util.HashMap;
import java.util.Map.Entry;

public class CacheManager {

	private static HashMap<Object, Cacheable> cacheHashMap = new HashMap<Object, Cacheable>();

	// Create background thread, which will be responsible for purging expired
	// items.
	static {
		try {

			Thread threadCleanerUpper = new Thread(new Runnable() {

				// The default time the thread should sleep between scans
				int milliSecondSleepTime = 5000;

				public void run() {
					try {

						// The thread will continue looping forever
						while (true) {
							System.out.println("ThreadCleanerUpper Scanning For	Expired Objects...");

							for (Entry<Object, Cacheable> entry : cacheHashMap.entrySet()) {
								Object key = entry.getKey();
								Cacheable value = entry.getValue();
								if (value.isExpired()) {
									cacheHashMap.remove(key);
									System.out.println(
											"ThreadCleanerUpper Running. Found an Expired Object in the Cache.");
								}
							}

							/*
							 ************************************************************************
							 ******* A LRU or LFU ***** would best beinserted here
							 ************************************************************************
							 */

							Thread.sleep(this.milliSecondSleepTime);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					return;
				}
			});

			threadCleanerUpper.setPriority(Thread.MIN_PRIORITY);
			threadCleanerUpper.start();
		} catch (Exception e) {
			System.out.println("CacheManager.Static Block: " + e);
		}
	}

	public CacheManager() {
	}

	public static void putCache(Cacheable object) {
		cacheHashMap.put(object.getIdentifier(), object);
	}

	public static Cacheable getCache(Object identifier) {
		// synchronized (lock){ // UNCOMMENT LINE XXX
		Cacheable object = (Cacheable) cacheHashMap.get(identifier);
		// The code to create the object would be placed here.
		// } // UNCOMMENT LINE XXX
		if (object == null)
			return null;
		if (object.isExpired()) {
			cacheHashMap.remove(identifier);
			return null;
		} else {
			return object;
		}
	}

}
