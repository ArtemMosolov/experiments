package week_1.core.concurrency;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* 
	Test started for: class java.util.Hashtable
	2500K entried added/retrieved in 1548 ms
	2500K entried added/retrieved in 1880 ms
	2500K entried added/retrieved in 1658 ms
	2500K entried added/retrieved in 1594 ms
	2500K entried added/retrieved in 1566 ms
	For class java.util.Hashtable the average time is 1649 ms
	
	Test started for: class java.util.Collections$SynchronizedMap
	2500K entried added/retrieved in 2309 ms
	2500K entried added/retrieved in 1519 ms
	2500K entried added/retrieved in 1537 ms
	2500K entried added/retrieved in 1493 ms
	2500K entried added/retrieved in 1672 ms
	For class java.util.Collections$SynchronizedMap the average time is 1706 ms
	
	Test started for: class java.util.concurrent.ConcurrentHashMap
	2500K entried added/retrieved in 589 ms
	2500K entried added/retrieved in 627 ms
	2500K entried added/retrieved in 474 ms
	2500K entried added/retrieved in 1154 ms
	2500K entried added/retrieved in 427 ms
	For class java.util.concurrent.ConcurrentHashMap the average time is 654 ms

*/

public class CrunchifyConcurrentHashMapVsSynchronizedMap {

	public final static int THREAD_POOL_SIZE = 5;

	public static Map<String, Integer> crunchifyHashMapObject = null;
	public static Map<String, Integer> crunchifyHashTableObject = null;
	public static Map<String, Integer> crunchifySynchronizedMapObject = null;
	public static Map<String, Integer> crunchifyConcurrentHashMapObject = null;

	public static void main(String[] args) throws InterruptedException {

		// Test with HashMap Object
		crunchifyHashMapObject = new HashMap<String, Integer>();
		crunchifyPerformTest(crunchifyHashMapObject);
		
		// Test with Hashtable Object
		crunchifyHashTableObject = new Hashtable<String, Integer>();
		crunchifyPerformTest(crunchifyHashTableObject);

		// Test with synchronizedMap Object
		crunchifySynchronizedMapObject = Collections.synchronizedMap(new HashMap<String, Integer>());
		crunchifyPerformTest(crunchifySynchronizedMapObject);

		// Test with ConcurrentHashMap Object
		crunchifyConcurrentHashMapObject = new ConcurrentHashMap<String, Integer>();
		crunchifyPerformTest(crunchifyConcurrentHashMapObject);

	}

	public static void crunchifyPerformTest(final Map<String, Integer> crunchifyThreads) throws InterruptedException {

		System.out.println("Test started for: " + crunchifyThreads.getClass());
		long averageTime = 0;
		for (int i = 0; i < 5; i++) {

			long startTime = System.nanoTime();
			ExecutorService crunchifyExServer = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

			for (int j = 0; j < THREAD_POOL_SIZE; j++) {
				crunchifyExServer.execute(new Runnable() {
					@SuppressWarnings("unused")
					@Override
					public void run() {

						for (int i = 0; i < 500000; i++) {
							Integer crunchifyRandomNumber = i;//(int) Math.ceil(Math.random() * 550000);

							// Retrieve value. We are not using it anywhere
							Integer crunchifyValue = crunchifyThreads.get(String.valueOf(crunchifyRandomNumber));

							// Put value
							crunchifyThreads.put(String.valueOf(crunchifyRandomNumber), crunchifyRandomNumber);
						}
					}
				});
			}

			// Make sure executor stops
			crunchifyExServer.shutdown();

			// Blocks until all tasks have completed execution after a shutdown
			// request
			crunchifyExServer.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);

			long entTime = System.nanoTime();
			long totalTime = (entTime - startTime) / 1000000L;
			averageTime += totalTime;
			System.out.println("2500K entried added/retrieved in " + totalTime + " ms");
		}
		System.out.println("For " + crunchifyThreads.getClass() + " the average time is " + averageTime / 5 + " ms\n");
	}
}
