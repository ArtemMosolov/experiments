package week_1.core.general.java8.lambda;

public class Lambda {

	public static void main(String[] args) {
		// ===  Anonymous class
		Operationable op = new Operationable() {
			public int calculate(int x, int y) {
				return x + y;
			}
		};
		int z = op.calculate(20, 10);
		System.out.println(z); // 30
		
		// === Lambda expression block and line
		
		Operationable operation1;
		operation1 = (x, y) -> x + y;
		
		Operationable operation2;
		operation2 = (x, y) -> {
				return x + y;
			};

		int result1 = operation1.calculate(10, 20);
		System.out.println(result1); // 30
		int result2 = operation2.calculate(10, 20);
		System.out.println(result2); // 30

	}

	@FunctionalInterface
	interface Operationable {
		int calculate(int x, int y);
	}

}
