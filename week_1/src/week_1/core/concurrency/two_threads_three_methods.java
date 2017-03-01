package week_1.core.concurrency;

public class two_threads_three_methods {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("============================");
		System.out.println("simple Method");
		System.out.println("============================");
		simpleMethodTest();
		
		Thread.currentThread().sleep(1000);
		
		System.out.println("============================");
		System.out.println("simple Synchronized Static Method");
		simpleSynchronizedStaticMethodTest();
		System.out.println("============================");
		
		Thread.currentThread().sleep(2000);
		
		System.out.println("============================");
		System.out.println("simple Synchronized Method");
		simpleSynchronizedMethodTest();
		System.out.println("============================");
		
		Thread.currentThread().sleep(2000);
	}
	
	public static void simpleMethodTest() {
		TestThreads test = new TestThreads();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				test.simpleMethod("t1");
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				test.simpleMethod("t2");
			}
		});
		
		t1.start();
		t2.start();
	}
	
	
	public static void simpleSynchronizedStaticMethodTest() {
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				TestThreads.simpleSynchronizedStaticMethod("t1");
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				TestThreads.simpleSynchronizedStaticMethod("t2");
			}
		});
		
		t1.start();
		t2.start();
	}
	
	public static void simpleSynchronizedMethodTest() {
		
		TestThreads test = new TestThreads();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				test.simpleSynchronizedMethod("t1");
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				test.simpleSynchronizedMethod("t2");
			}
		});
		
		t1.start();
		t2.start();
	}
	
}

class TestThreads {

	public void simpleMethod(String threadName) {
		System.out.println("enter " + threadName);
		System.out.println("simple method");
		//sleep();
		System.out.println("exit " + threadName);
	}
	
	public synchronized static void simpleSynchronizedStaticMethod(String threadName) {
		System.out.println("enter " + threadName);
		System.out.println("simple synchronized static method");
		//sleep();
		System.out.println("exit " + threadName);
	}
	
	public synchronized void simpleSynchronizedMethod(String threadName) {
		System.out.println("enter " + threadName);
		System.out.println("simple synchronized method");
		//sleep();
		System.out.println("exit " + threadName);
	}
	
	public static void sleep() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
