package week_1.gof_patterns.creational;

public class Prototype {
	public static void main(String[] args) throws CloneNotSupportedException {
		ConcretePrototype obj1 = new ConcretePrototype ();
		ConcretePrototype obj2 = (ConcretePrototype) obj1.clone();
	}
}

class ConcretePrototype {
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
