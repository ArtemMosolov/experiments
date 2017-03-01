package week_1.core.general;

/*
 * 
 *   Throwable - checked
 *   Exception - checked
 *   RuntimeException - unchecked
 *   Error - unchecked
 * 
 */

public class errors_checked_or_unchecked {

	public static void main(String[] args) {
		
		printMemory();
		
		try {
			
			int[] array1 = new int[Integer.MAX_VALUE / 1000];
			printMemory();
			
			createOOME();
			
		} catch (Error e) {
			System.out.println(e);
		}
		
		printMemory();
		
	}
	
	public static void createOOME() {
		try {
			int[] array = new int[Integer.MAX_VALUE];
		} catch (Error e) {  // java.lang.OutOfMemoryError: Requested array size exceeds VM limit
			System.out.println(e);
		}
	}
	
	public static void printMemory() {
		Runtime runtime = Runtime.getRuntime();
		System.out.println("free memory " + (runtime.freeMemory() / 1024));
		System.out.println("allocated memory " + (runtime.totalMemory() / 1024));
		System.out.println("max memory " + (runtime.maxMemory() / 1024));
		System.out.println();
	}
	
}
