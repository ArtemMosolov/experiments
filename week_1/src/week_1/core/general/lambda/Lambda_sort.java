package week_1.core.general.lambda;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Lambda_sort {
	
	private final static Integer SIZE = 1_00;
	
	public static void main(String[] args) {

		Long startTime;
		Long stopTime;
		List<Integer> array;
		
		//START -------------------------------------------------------------------------------------
		array = new LinkedList<Integer>();
		feelArray(array);
		startTime = System.currentTimeMillis();
		/// custom comparator, the same as already implemented inside Collections.sort
		sortByCustomComparator(array);
		stopTime = System.currentTimeMillis();
		System.out.println("Sorting by using custom coparator");
		System.out.println("Time taken : " + (stopTime - startTime) + " ms");
		//END ---------------------------------------------------------------------------------------
		
		//START -------------------------------------------------------------------------------------
		array = new LinkedList<Integer>();
		feelArray(array);
		startTime = System.currentTimeMillis();
		// custom comparator via lambda expression (new java 8 feature)
		sortByCustomComparatorLambda(array);
		stopTime = System.currentTimeMillis();
		System.out.println("Sorting by using lambda expression");
		System.out.println("Time taken : " + (stopTime - startTime) + " ms");
		//END ---------------------------------------------------------------------------------------

	}
	
	private static void feelArray(List<Integer> list) {
		for(int k = SIZE; k > 0; k--) {
			list.add(k);
		}
	}
	
	private static void sortByCustomComparator(List<Integer> array) {
		Collections.sort(array, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
	}
	
	private static void sortByCustomComparatorLambda(List<Integer> array) {
		Collections.sort(array, (Integer o1, Integer o2) -> o1 - o2);
	}
}