package week_1.core.concurrency;

/* 
 *   RESULT :
 *  
 *  	random write / read
 *  
	Thread with name 1 inc counter to : 2
	Thread with name 0 inc counter to : 2
	Thread with name 2 inc counter to : 2
	Thread with name 0 inc counter to : 4
	Thread with name 2 inc counter to : 5
	Thread with name 1 inc counter to : 4
	Thread with name 1 inc counter to : 6
	Thread with name 0 inc counter to : 7
	Thread with name 2 inc counter to : 6
	Final result 7

		synchronized method
	
	Thread with name 0 inc counter to : 1
	Thread with name 0 inc counter to : 2
	Thread with name 0 inc counter to : 3
	Thread with name 2 inc counter to : 4
	Thread with name 2 inc counter to : 5
	Thread with name 2 inc counter to : 6
	Thread with name 1 inc counter to : 7
	Thread with name 1 inc counter to : 8
	Thread with name 1 inc counter to : 9
	Final result 9

		Lock
	
	Thread with name 0 inc counter to : 1
	Thread with name 0 inc counter to : 2
	Thread with name 0 inc counter to : 3
	Thread with name 1 inc counter to : 4
	Thread with name 1 inc counter to : 5
	Thread with name 1 inc counter to : 6
	Thread with name 2 inc counter to : 7
	Thread with name 2 inc counter to : 8
	Thread with name 2 inc counter to : 9
	Final result 9

		synchronized method + volatile keyword

	Thread with name 2 inc counter volatile to : 1
	Thread with name 2 inc counter volatile to : 2
	Thread with name 2 inc counter volatile to : 3
	Thread with name 1 inc counter volatile to : 4
	Thread with name 1 inc counter volatile to : 5
	Thread with name 1 inc counter volatile to : 6
	Thread with name 0 inc counter volatile to : 7
	Thread with name 0 inc counter volatile to : 8
	Thread with name 0 inc counter volatile to : 9
	Final result 9


 * 
 * 
 * 
 * 
 * */

import java.util.concurrent.locks.ReentrantLock;

public class Lock_vs_Sync_vs_Random_vs_Volatile {
	public static void main(String[] args) throws InterruptedException {
		
		Counter counter1 = new Counter();
		for(int i = 0; i < 3; i++) {
			Thread t = new Thread(new CounterThread(String.valueOf(i), counter1));
			t.start();
		}
		Thread.sleep(3000);
		System.out.println("Final result " + counter1.count);
		//====================================================
		Counter counter2 = new Counter();
		for(int i = 0; i < 3; i++) {
			Thread t = new Thread(new CounterThreadSync(String.valueOf(i), counter2));
			t.start();
		}
		Thread.sleep(2000);
		System.out.println("Final result " + counter2.count);
		//====================================================
		Counter counter3 = new Counter();
		ReentrantLock locker = new ReentrantLock();
		for(int i = 0; i < 3; i++) {
			Thread t = new Thread(new CounterThreadLock(String.valueOf(i), counter3, locker));
			t.start();
		}
		Thread.sleep(2000);
		System.out.println("Final result " + counter3.count);
		//====================================================
		Counter counter4 = new Counter();
		for(int i = 0; i < 3; i++) {
			Thread t = new Thread(new CounterThreadVol(String.valueOf(i), counter4));
			t.start();
		}
		Thread.sleep(2000);
		System.out.println("Final result " + counter4.count_volatile);
		
	}
}

class Counter {
	int count = 0;
	volatile int count_volatile = 0;
	
	public synchronized void incCountVolatile(String threadName) {
		for(int i = 0; i < 3; i++) {
			try {
				Thread.sleep(100);
				count_volatile++;
				System.out.println("Thread with name " + threadName + " inc counter volatile to : " + count_volatile);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void incCount(String threadName) {
		for(int i = 0; i < 3; i++) {
			try {
				Thread.sleep(100);
				count++;
				System.out.println("Thread with name " + threadName + " inc counter to : " + count);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void incCountSync(String threadName) {
		for(int i = 0; i < 3; i++) {
			count++;
			System.out.println("Thread with name " + threadName + " inc counter to : " + count);
		}
	}
	
	public void incCountLock(String threadName) {
		for(int i = 0; i < 3; i++) {
			count++;
			System.out.println("Thread with name " + threadName + " inc counter to : " + count);
		}
	}
	
}

class CounterThread implements Runnable {
	private Counter counter;
	private String threadName;
	public CounterThread(String threadName, Counter counter) {
		super();
		this.threadName = threadName;
		this.counter = counter;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(100);
			counter.incCount(threadName);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}

class CounterThreadVol implements Runnable {
	private Counter counter;
	private String threadName;
	public CounterThreadVol(String threadName, Counter counter) {
		super();
		this.threadName = threadName;
		this.counter = counter;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(100);
			counter.incCountVolatile(threadName);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}

class CounterThreadSync implements Runnable {
	private Counter counter;
	private String threadName;
	public CounterThreadSync(String threadName, Counter counter) {
		super();
		this.threadName = threadName;
		this.counter = counter;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(100);
			counter.incCountSync(threadName);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class CounterThreadLock implements Runnable {
	private Counter counter;
	private String threadName;
	private ReentrantLock locker;
	public CounterThreadLock(String threadName, Counter counter, ReentrantLock locker) {
		super();
		this.threadName = threadName;
		this.counter = counter;
		this.locker = locker;
	}
	
	@Override
	public void run() {
		locker.lock();
		try {
			counter.incCountLock(threadName);
			Thread.sleep(100);
		} catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
        finally{
            locker.unlock();
        }
	}
}
