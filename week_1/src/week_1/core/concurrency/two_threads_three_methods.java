package week_1.core.concurrency;
/*
RESULT :
============================
simple Method
============================
enter simple Method Thread 1
enter simple Method Thread 2
exit  simple Method Thread 1
exit  simple Method Thread 2
============================
simple Synchronized Method
============================
enter simple Synchronized Method Thread 2
exit  simple Synchronized Method Thread 2
enter simple Synchronized Static Method Thread 3
exit  simple Synchronized Static Method Thread 3
enter simple Synchronized Method Thread 1
exit  simple Synchronized Method Thread 1
============================
simple Synchronized Static Method
============================
enter simple Synchronized Static Method Thread 1
exit  simple Synchronized Static Method Thread 1
enter simple Synchronized Method Thread 3
exit  simple Synchronized Method Thread 3
enter simple Synchronized Static Method Thread 2
exit  simple Synchronized Static Method Thread 2

*/
public class two_threads_three_methods {
	
	public static void main(String[] args) throws InterruptedException {
		
		/*System.out.println("============================");
		System.out.println("simple Method");
		System.out.println("============================");
		simpleMethodTest();
		
		Thread.currentThread().sleep(10000);*/
		
		/*System.out.println("============================");
		System.out.println("simple Synchronized Method");
		simpleSynchronizedMethodTest();
		System.out.println("============================");
		*/
		//Thread.currentThread().sleep(10000);
		
		System.out.println("============================");
		System.out.println("simple Synchronized Static Method");
		simpleSynchronizedStaticMethodTest();
		System.out.println("============================");
		
	}
	
	public static void simpleMethodTest() {
		TestThreads test = new TestThreads();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				test.simpleMethod("Thread 1");
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				test.simpleMethod("Thread 2");
			}
		});
		
		t1.start();
		t2.start();
	}
	
	
	public static void simpleSynchronizedStaticMethodTest() {
		
		TestThreads test = new TestThreads();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				//sleep();
				TestThreads.simpleSynchronizedStaticMethod("Thread 1");
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				//sleep();
				TestThreads.simpleSynchronizedStaticMethod("Thread 2");
			}
		});
				
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				//sleep();
				test.simpleSynchronizedMethod("Thread 3");
			}
		});
		
		t1.start();
		t2.start();
		t3.start();
		
	}
	
	public static void simpleSynchronizedMethodTest() {
		
		TestThreads test = new TestThreads();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				//sleep();
				test.simpleSynchronizedMethod("Thread 1");
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				//sleep();
				test.simpleSynchronizedMethod("Thread 2");
			}
		});
		
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				//sleep();
				TestThreads.simpleSynchronizedStaticMethod("Thread 3");
			}
		});
		
		t1.start();
		t2.start();
		t3.start();
	}
	
	public static void sleep() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

class TestThreads {

	public void simpleMethod(String threadName) {
		System.out.println("enter simple Method " + threadName);
		System.out.println("exit  simple Method " + threadName);
		sleep();
	}
	
	public synchronized static void simpleSynchronizedStaticMethod(String threadName) {
		System.out.println("enter simple Synchronized Static Method " + threadName);
		System.out.println("exit  simple Synchronized Static Method " + threadName);
		sleep();
	}
	
	public synchronized void simpleSynchronizedMethod(String threadName) {
		System.out.println("enter simple Synchronized Method " + threadName);
		System.out.println("exit  simple Synchronized Method " + threadName);
		sleep();
	}
	
	public static void sleep() {
		try {
			Thread.currentThread().sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
