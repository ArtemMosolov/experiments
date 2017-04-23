package week_1.gof_patterns.structural;

import java.util.ArrayList;
import java.util.List;

public class Composite {
	public static void main(String[] args) {

		// Initialize four ellipses
		Ellipse ellipse1 = new Ellipse();
		Ellipse ellipse2 = new Ellipse();
		Ellipse ellipse3 = new Ellipse();
		Ellipse ellipse4 = new Ellipse();

		// Initialize three composite graphics
		CompositeGraphic graphic = new CompositeGraphic();
		CompositeGraphic graphic1 = new CompositeGraphic();
		CompositeGraphic graphic2 = new CompositeGraphic();

		// Composes the graphics
		graphic1.add(ellipse1);
		graphic1.add(ellipse2);
		graphic1.add(ellipse3);

		graphic2.add(ellipse4);

		graphic.add(graphic1);
		graphic.add(graphic2);

		// Prints the complete graphic (four times the string "Ellipse").
		graphic.print();

	}
}

interface Graphic {
	public void print();
}

class CompositeGraphic implements Graphic {

	private List<Graphic> mChildGraphics = new ArrayList<Graphic>();

	public void print() {
		for (Graphic graphic : mChildGraphics) {
			graphic.print();
		}
	}

	public void add(Graphic graphic) {
		mChildGraphics.add(graphic);
	}

	public void remove(Graphic graphic) {
		mChildGraphics.remove(graphic);
	}
}

class Ellipse implements Graphic {

	public void print() {
		System.out.println("Ellipse");
	}

}
