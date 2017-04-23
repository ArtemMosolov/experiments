package week_1.gof_patterns.creational;

public class Singleton {
	public static void main(String[] args) {

	}
}

class SingletonGoodWithBadPerfomance {
	private static SingletonGoodWithBadPerfomance instance;

	private SingletonGoodWithBadPerfomance() {
	}

	public static synchronized SingletonGoodWithBadPerfomance getInstance() {
		if (instance == null)
			instance = new SingletonGoodWithBadPerfomance();

		return instance;
	}

	public void doSomething() {
	}
}

// ===============

class SingletonBest {
	private static SingletonBest instance;

	private SingletonBest() {
		System.out.println("Singleton(): Initializing Instance");
	}

	public static SingletonBest getInstance() {
		if (instance == null) {
			synchronized (SingletonBest.class) {
				if (instance == null) {
					System.out.println("getInstance(): First time getInstance was invoked!");
					instance = new SingletonBest();
				}
			}
		}
		return instance;
	}

	public void doSomething() {
		System.out.println("doSomething(): Singleton does something!");
	}
}

// ===============

class SingletonStatic {
	private static SingletonStatic instance = new SingletonStatic();

	private SingletonStatic() {
		System.out.println("Singleton(): Initializing Instance");
	}

	public static SingletonStatic getInstance() {
		return instance;
	}

	public void doSomething() {
		System.out.println("doSomething(): Singleton does something!");
	}
}
