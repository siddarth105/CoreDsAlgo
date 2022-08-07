package Algo.LRUCache;

import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class CacheManager {
	
	private static Map<Cacheable, DllNode> lruHashMap = new ConcurrentHashMap<>();
	static DllNode head; // least recently used item
	static DllNode tail; // most recently used item
	
	private static int lruCacheSize;
	private static int currentCacheSize;

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

							for (Entry<Cacheable, DllNode> entry : lruHashMap.entrySet()) {
								Cacheable key = entry.getKey();
								if (key.isExpired()) {
									lruHashMap.remove(key);
									System.out.println(
											"ThreadCleanerUpper Running. Found an Expired Object in the Cache.");
								}
							}
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
	
	public static synchronized Cacheable getValueFromLruCache(Cacheable cacheable) {
		DllNode ddlNode = lruHashMap.get(cacheable);
		if (null != ddlNode) {
			ddlNode.prev.next = ddlNode.next;
			ddlNode.next.prev = ddlNode.prev;
			
			//Add the most recently used item to the tail
			tail.next = ddlNode;
			ddlNode.prev = tail;
			tail = ddlNode;
			
			//Reset the ttl from the time of access
			cacheable.resetTtl();
		}
		return cacheable;
	}
	
	public static synchronized void putLruCache(Cacheable cacheable) {
		
		DllNode ddlNode = lruHashMap.get(cacheable);
		if (null != ddlNode) {
			//Already present in the cache
			ddlNode.prev.next = ddlNode.next;
			ddlNode.next.prev = ddlNode.prev;
		} else {
			//Not present in the cache
			ddlNode = new DllNode(cacheable.getValue()); 
			if (currentCacheSize < lruCacheSize) {
				currentCacheSize ++;
			} else {
				
				//Remove the least recently used item from the head
				lruHashMap.remove(head);
				head = head.next;
			}
			lruHashMap.put(cacheable, ddlNode);
		}
		
		//Add the most recently used item to the tail
		tail.next = ddlNode;
		ddlNode.prev = tail;
		tail = ddlNode;
		
		//Reset the ttl from the time of access
		cacheable.resetTtl();
	}

}
