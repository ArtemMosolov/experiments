package week_1.gof_patterns.structural;

import java.util.HashMap;

public class Flyweight {
	public static void main(String[] args) {

		FlyweightFactory factory = new FlyweightFactory();
		int[] characterCodes = { 1, 2, 3 };
		for (int nextCode : characterCodes) {
			EnglishCharacter character = factory.getCharacter(nextCode);
			character.printCharacter();
		}

	}
}

abstract class EnglishCharacter {

	protected char symbol;

	protected int width;

	protected int height;

	public abstract void printCharacter();

}

class CharacterA extends EnglishCharacter {

	public CharacterA() {
		symbol = 'A';
		width = 10;
		height = 20;
	}

	@Override
	public void printCharacter() {
		System.out.println("Simbol = " + symbol + " Width = " + width + " Height = " + height);
	}

}

class CharacterB extends EnglishCharacter {

	public CharacterB() {
		symbol = 'B';
		width = 20;
		height = 30;
	}

	@Override
	public void printCharacter() {
		System.out.println("Simbol = " + symbol + " Width = " + width + " Height = " + height);
	}

}

class CharacterC extends EnglishCharacter {

	public CharacterC() {
		symbol = 'C';
		width = 40;
		height = 50;
	}

	@Override
	public void printCharacter() {
		System.out.println("Simbol = " + symbol + " Width = " + width + " Height = " + height);
	}

}

class FlyweightFactory {

	private HashMap<Integer, EnglishCharacter> characters = new HashMap<Integer, EnglishCharacter>();

	public EnglishCharacter getCharacter(int characterCode) {
		EnglishCharacter character = characters.get(new Integer(characterCode));
		if (character == null) {
			switch (characterCode) {
			case 1: {
				character = new CharacterA();
				break;
			}
			case 2: {
				character = new CharacterB();
				break;
			}
			case 3: {
				character = new CharacterC();
				break;
			}
			}
			characters.put(characterCode, character);
		}
		return character;
	}
}