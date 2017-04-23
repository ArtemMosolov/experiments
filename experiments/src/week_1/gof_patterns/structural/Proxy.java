package week_1.gof_patterns.structural;

public class Proxy {
	public static void main(String[] args) {

		// Create math proxy
		IMath p = new MathProxy();

		// Do the math
		System.out.println("4 + 2 = " + p.add(4, 2));
		System.out.println("4 - 2 = " + p.sub(4, 2));
		System.out.println("4 * 2 = " + p.mul(4, 2));
		System.out.println("4 / 2 = " + p.div(4, 2));

	}
}

interface IMath {

	public double add(double x, double y);

	public double sub(double x, double y);

	public double mul(double x, double y);

	public double div(double x, double y);
}

class Math implements IMath {

	public double add(double x, double y) {
		return x + y;
	}

	public double sub(double x, double y) {
		return x - y;
	}

	public double mul(double x, double y) {
		return x * y;
	}

	public double div(double x, double y) {
		return x / y;
	}
}

class MathProxy implements IMath {

	private Math math;

	public double add(double x, double y) {
		if (math == null) {
			math = new Math();
		}
		return math.add(x, y);
	}

	public double sub(double x, double y) {
		if (math == null) {
			math = new Math();
		}
		return math.sub(x, y);
	}

	public double mul(double x, double y) {
		if (math == null) {
			math = new Math();
		}
		return math.mul(x, y);
	}

	public double div(double x, double y) {
		if (math == null) {
			math = new Math();
		}
		return math.div(x, y);
	}
}