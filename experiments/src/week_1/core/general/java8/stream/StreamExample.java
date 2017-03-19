package week_1.core.general.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.*;
public class StreamExample {
	public static void main(String[] args) {
		
		//  http://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html
		
		List<String> text = new ArrayList<>();
		text.add("book");
		text.add("apple");
		text.add("window");
		text.add("notebook");
		text.add("job");
		text.add("job");
		
		// sorting
		text.stream().sorted().forEach(System.out::println);
		System.out.println("===");
		
		// only unique 
		text.stream().distinct().forEach(System.out::println);
		System.out.println("===");
		
		// limit
		text.stream().limit(2).forEach(System.out::println);
		System.out.println("===");
		
		// filter
		text.stream().filter(value -> value.startsWith("j")).forEach(System.out::println);
		System.out.println("===");
		
		// add some effects 
		text.stream().map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
		System.out.println("===");
		
		// convert to some collections
		text.stream().collect(Collectors.toList()).forEach(s -> System.out.println(s));
		System.out.println("===");
		
		// count of elements
		System.out.println(text.stream().count());
		System.out.println("===");
		
		// skip 4 elements
		text.stream().skip(4).forEach(s -> System.out.println(s));
		System.out.println("===");
	}
}

