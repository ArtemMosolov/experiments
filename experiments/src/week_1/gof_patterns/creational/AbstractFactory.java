package week_1.gof_patterns.creational;

public class AbstractFactory {
	public static void main(String[] args) {
		AbstractFactoryProducts pf = FactoryMaker.getFactory("a");
		AbstractProductA product = pf.createProductA();
	}
}

abstract class AbstractProductA {
	public abstract void operationA1();

	public abstract void operationA2();
}

class ProductA1 extends AbstractProductA {
	ProductA1(String arg) {
		System.out.println("Hello " + arg);
	}

	public void operationA1() {
	};

	public void operationA2() {
	};
}

class ProductA2 extends AbstractProductA {
	ProductA2(String arg) {
		System.out.println("Hello " + arg);
	}

	public void operationA1() {
	};

	public void operationA2() {
	};
}

abstract class AbstractProductB {
	// public abstract void operationB1();
	// public abstract void operationB2();
}

class ProductB1 extends AbstractProductB {
	ProductB1(String arg) {
		System.out.println("Hello " + arg);
	} // Implement the code here
}

class ProductB2 extends AbstractProductB {
	ProductB2(String arg) {
		System.out.println("Hello " + arg);
	} // Implement the code here
}

abstract class AbstractFactoryProducts {
	abstract AbstractProductA createProductA();

	abstract AbstractProductB createProductB();
}

class ConcreteFactory1 extends AbstractFactoryProducts {
	AbstractProductA createProductA() {
		return new ProductA1("ProductA1");
	}

	AbstractProductB createProductB() {
		return new ProductB1("ProductB1");
	}
}

class ConcreteFactory2 extends AbstractFactoryProducts {
	AbstractProductA createProductA() {
		return new ProductA2("ProductA2");
	}

	AbstractProductB createProductB() {
		return new ProductB2("ProductB2");
	}
}

// Factory creator - an indirect way of instantiating the factories
class FactoryMaker {
	private static AbstractFactoryProducts pf = null;

	static AbstractFactoryProducts getFactory(String choice) {
		if (choice.equals("a")) {
			pf = new ConcreteFactory1();
		} else if (choice.equals("b")) {
			pf = new ConcreteFactory2();
		}
		return pf;
	}
}
