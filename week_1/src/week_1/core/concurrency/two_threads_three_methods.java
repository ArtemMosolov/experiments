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
simple Synchronized Method     CASE 1
============================
enter simple Synchronized Method 1 Thread 1
enter simple Synchronized Static Method Thread 3
exit  simple Synchronized Static Method Thread 3
exit  simple Synchronized Method 1 Thread 1
enter simple Synchronized Method 2 Thread 2
exit  simple Synchronized Method 2 Thread 2
============================
simple Synchronized Method	   CASE 2
============================
enter simple Synchronized Static Method Thread 3
enter simple Synchronized Method 1 Thread 1
exit  simple Synchronized Method 1 Thread 1
enter simple Synchronized Method 2 Thread 2
exit  simple Synchronized Method 2 Thread 2
exit  simple Synchronized Static Method Thread 3
============================
simple Synchronized Static Method
============================
enter simple Synchronized Static Method 1 Thread 1
exit  simple Synchronized Static Method 1 Thread 1
enter simple Synchronized Static Method 1 Thread 2
enter simple Synchronized Method 1 Thread 3
exit  simple Synchronized Method 1 Thread 3
exit  simple Synchronized Static Method 1 Thread 2
enter simple Synchronized Static Method 2 Thread 4
exit  simple Synchronized Static Method 2 Thread 4

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
		System.out.println("============================");*/
		
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
				TestThreads.simpleSynchronizedStaticMethod1("Thread 1");
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				//sleep();
				TestThreads.simpleSynchronizedStaticMethod1("Thread 2");
			}
		});
				
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				//sleep();
				test.simpleSynchronizedMethod1("Thread 3");
			}
		});
		
		Thread t4 = new Thread(new Runnable() {
			@Override
			public void run() {
				//sleep();
				TestThreads.simpleSynchronizedStaticMethod2("Thread 4");
			}
		});
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
	}
	
	public static void simpleSynchronizedMethodTest() {
		
		TestThreads test = new TestThreads();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				//sleep();
				test.simpleSynchronizedMethod1("Thread 1");
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				//sleep();
				test.simpleSynchronizedMethod2("Thread 2");
			}
		});
		
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				//sleep();
				TestThreads.simpleSynchronizedStaticMethod1("Thread 3");
			}
		});
		t3.start();
		t1.start();
		t2.start();
		
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
		//sleep();
	}
	
	public synchronized static void simpleSynchronizedStaticMethod1(String threadName) {
		System.out.println("enter simple Synchronized Static Method 1 " + threadName);
		System.out.println("exit  simple Synchronized Static Method 1 " + threadName);
		//sleep();
	}
	
	public synchronized static void simpleSynchronizedStaticMethod2(String threadName) {
		System.out.println("enter simple Synchronized Static Method 2 " + threadName);
		System.out.println("exit  simple Synchronized Static Method 2 " + threadName);
		//sleep();
	}
	
	public synchronized void simpleSynchronizedMethod1(String threadName) {
		System.out.println("enter simple Synchronized Method 1 " + threadName);
		System.out.println("exit  simple Synchronized Method 1 " + threadName);
		//sleep();
	}
	
	public synchronized void simpleSynchronizedMethod2(String threadName) {
		System.out.println("enter simple Synchronized Method 2 " + threadName);
		System.out.println("exit  simple Synchronized Method 2 " + threadName);
		//sleep();
	}
	
	public static void sleep() {
		try {
			Thread.currentThread().sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
