package week_1.gof_patterns.structural;

public class Adapter {

	public static void eat(Object dish) {
	}

	public static void main(String[] args) {

		Chief ch = new ChiefAdapter();
		Object dish = ch.makeBreakfast();
		eat(dish);
		dish = ch.makeLunch();
		eat(dish);
		dish = ch.makeDinner();
		eat(dish);
	}
}

interface Chief {
	public Object makeBreakfast();

	public Object makeLunch();

	public Object makeDinner();
}

// Adaptee
class Plumber {
	public Object getScrewNut() {
		return null;
	}

	public Object getPipe() {
		return null;
	}

	public Object getGasket() {
		return null;
	}
}

// Adapter
class ChiefAdapter extends Plumber implements Chief {
	public Object makeBreakfast() {
		return getGasket();
	}

	public Object makeLunch() {
		return getPipe();
	}

	public Object makeDinner() {
		return getScrewNut();
	}
}