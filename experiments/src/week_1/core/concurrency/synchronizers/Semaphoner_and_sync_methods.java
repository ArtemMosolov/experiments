package week_1.core.concurrency.synchronizers;

import java.util.concurrent.Semaphore;

/* 
 	Enter sync_method_1 Thread name t1Exception in thread "Thread-0" java.lang.RuntimeException
	at week_1.core.concurrency.synchronizers.Resource.sync_method_2(Semaphoner_and_sync_methods.java:55)
	at week_1.core.concurrency.synchronizers.Resource.sync_method_1(Semaphoner_and_sync_methods.java:44)
	at week_1.core.concurrency.synchronizers.Semaphoner_and_sync_methods$1.run(Semaphoner_and_sync_methods.java:14)
	at java.lang.Thread.run(Thread.java:745)

	Enter sync_method_2 Thread name t1
	Enter sync_method_2 Thread name t2

 */

public class Semaphoner_and_sync_methods {
	
	public static void main(String[] args) {
		Semaphore sem = new Semaphore(2);
		Resource resource = new Resource(sem);
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				Resource.sleep(1000);
				resource.sync_method_1("t1");
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				Resource.sleep(2000);
				resource.sync_method_2("t2");
			}
		});
		
		t1.start();
		t2.start();
		
	}
}

class Resource {
	
	Semaphore sem;
	
	public Resource(Semaphore sem) {
		super();
		this.sem = sem;
	}
	public void sync_method_1(String name) {
		System.out.println("Enter sync_method_1 Thread name " + name );
		try {
			//sleep(3000);
			sem.acquire();
			sync_method_2("t1");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Exit sync_method_1 Thread name " + name );
		sem.release();
	}
	public synchronized void sync_method_2(String name) {
		System.out.println("Enter sync_method_2 Thread name " + name );
		try {
			sem.acquire();
			if(name.equalsIgnoreCase("t1")) throw new RuntimeException();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sleep(5000);
		System.out.println("Exit sync_method_2 Thread name " + name );
		sem.release();
	}
	
	public static void sleep(int time) {
		try {
			Thread.currentThread().sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
