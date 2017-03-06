package week_1.core.general.function_interface;

import java.util.UUID;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FunctionInterface {
	public static void main(String[] args) {

		Predicate<Integer> isPositive = x -> x > 0;

		System.out.println(isPositive.test(5)); // true
		System.out.println(isPositive.test(-7)); // false

		BinaryOperator<Integer> multiply = (x, y) -> x * y;

		System.out.println(multiply.apply(3, 5)); // 15
		System.out.println(multiply.apply(10, -2)); // -20

		UnaryOperator<Integer> square = x -> x * x;
		System.out.println(square.apply(5)); // 25

		Function<Integer, String> convert = x -> String.valueOf(x) + " долларов";
		System.out.println(convert.apply(5)); // 5 долларов

		Consumer<Integer> printer = x -> System.out.printf("%d долларов \n", x);
		printer.accept(600); // 600 долларов

		Supplier<String> uuidFactory = () -> {
			UUID uuid = UUID.randomUUID();
			return uuid.toString();
		};

		System.out.println(uuidFactory.get());
	}
}
