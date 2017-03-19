package week_1.core.general.java8.method_reference;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Supplier;

public class MethodReference {
	public static void main(String[] args) {
		
		// http://www.studytrails.com/java/java8/java8_lambdas_functionalprogramming/
		
		Example ex = new Example();
		
		// Referencing static methods using Class Name
		ex.oper(Example::mul, 1, 2);
		
		// Referencing Instance methods using Object Instance
		ex.oper(ex::add, 1, 2);
		
		// Referencing Instance methods using Class Name
		ex.operS(String::toLowerCase, "STRING");
		
		// Referencing the constructor
		GregorianCalendar gc = ex.operC(GregorianCalendar::new);
		System.out.println(gc);
		
	}
}

class Example {
	 
    public int add(int a, int b) {
        return a + b;
    }
 
    public static int mul(int a, int b) {
        return a * b;
    }
 
    public String lower(String a) {
        return a.toLowerCase();
    }
 
    public void printDate(Date date) {
        System.out.println(date);
    }
 
    public void oper(IntBinaryOperator operator, int a, int b) {
        System.out.println(operator.applyAsInt(a, b));
    }
 
    public void operS(Function<String, String> stringOperator, String a) {
        System.out.println(stringOperator.apply(a));
    }
 
    public GregorianCalendar operC(Supplier<GregorianCalendar> supplier) {
        return supplier.get();
    }
 
}      