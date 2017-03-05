package week_1.core.general;

public class overloading_overriding_diffs_and_rules {

	public static void main(String[] args) {

		/*
		 * Overloading - compile-time 
		 * Overriding - runtime
		 * 
		 * Overloading at the same class 
		 * Overriding at base and child classes
		 * 
		 * Performance: Overloading gives better performance compared to
		 * overriding. The reason is that the binding of overridden methods is
		 * being done at runtime.
		 * 
		 * private and final methods can be overloaded but they cannot be
		 * overridden. It means a class can have more than one private/final
		 * methods of same name but a child class cannot override the
		 * private/final methods of their base class.
		 * 
		 * Overload rules :
		 * First and important rule to overload a method in java is to change method signature. 
		 * Method signature is made of number of arguments, type of arguments and order of arguments if they are of different types.
		 * Changing the return type of method does not amount to method overloading.
		 * Thrown exceptions from methods are also not considered when overloading a method.
		 * 
		 * Override rules :
		 * Argument list in overridden and overriding methods must be exactly same
		 * Return type of overriding method can be child class of return type declared in overridden method.
		 * Private, static and final methods can not be overridden
		 * Overriding method can not throw checked Exception higher in hierarchy
		 * Overriding method can not reduce the access scope of overridden method.
		 */
	}

}

class Sum {
	int add(int n1, int n2) {
		return n1 + n2;
	}

	int add(int n1, int n2, int n3) {
		return n1 + n2 + n3;
	}

	int add(int n1, int n2, int n3, int n4) {
		return n1 + n2 + n3 + n4;
	}

	int add(int n1, int n2, int n3, int n4, int n5) {
		return n1 + n2 + n3 + n4 + n5;
	}

	public static void main(String args[]) {
		Sum obj = new Sum();
		System.out.println("Sum of two numbers: " + obj.add(20, 21));
		System.out.println("Sum of three numbers: " + obj.add(20, 21, 22));
		System.out.println("Sum of four numbers: " + obj.add(20, 21, 22, 23));
		System.out.println("Sum of five numbers: " + obj.add(20, 21, 22, 23, 24));
	}
}

class CarClass {
	public int speedLimit() {
		return 100;
	}
}

class Ford extends CarClass {
	public int speedLimit() {
		return 150;
	}

	public static void main(String args[]) {
		CarClass obj = new Ford();
		int num = obj.speedLimit();
		System.out.println("Speed Limit is: " + num);
	}
}
