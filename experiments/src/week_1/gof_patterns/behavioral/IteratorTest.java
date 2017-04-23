package week_1.gof_patterns.behavioral;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			it.next();
		}
	}
}
