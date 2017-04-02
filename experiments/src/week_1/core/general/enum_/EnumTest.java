package week_1.core.general.enum_;

public class EnumTest {
	public static void main(String[] args) {

		Modifiers m = Modifiers.FINAL;

		System.out.println(Modifiers.FINAL);
		System.out.println(Modifiers.FINAL.getId());

		switch (m) {
		case PUBLIC:
			System.out.println("PUBLIC"); break;
		case STATIC:
			System.out.println("STATIC"); break;
		case FINAL:
			System.out.println("FINAL"); break;
		default:
			break;
		}
	}
}

// abstract class Modifiers extends java.lang.Enum

enum Modifiers {
	PUBLIC(1), STATIC(2), FINAL(3);

	Modifiers(int id) {
		this.id = id;
	}

	private int id;

	public int getId() {
		return id;
	}

	public static String getClassName() {
		return Modifiers.class.getName();
	}
}