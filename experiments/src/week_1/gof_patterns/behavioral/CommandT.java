package week_1.gof_patterns.behavioral;

public class CommandT {
	public static void main(String[] args) {

		Light l = new Light();
		Command switchUp = new TurnOnLightCommand(l);
		Command switchDown = new TurnOffLightCommand(l);

		Switch s = new Switch(switchUp, switchDown);

		s.flipUp();
		s.flipDown();

	}
}

class Switch {
	private Command flipUpCommand;
	private Command flipDownCommand;

	public Switch(Command flipUpCommand, Command flipDownCommand) {
		this.flipUpCommand = flipUpCommand;
		this.flipDownCommand = flipDownCommand;
	}

	public void flipUp() {
		flipUpCommand.execute();
	}

	public void flipDown() {
		flipDownCommand.execute();
	}
}

class Light {
	public Light() {
	}

	public void turnOn() {
		System.out.println("The light is on");
	}

	public void turnOff() {
		System.out.println("The light is off");
	}
}

interface Command {
	void execute();
}

/* the Command for turning on the light */

class TurnOnLightCommand implements Command {
	private Light theLight;

	public TurnOnLightCommand(Light light) {
		this.theLight = light;
	}

	public void execute() {
		theLight.turnOn();
	}
}

class TurnOffLightCommand implements Command {
	private Light theLight;

	public TurnOffLightCommand(Light light) {
		this.theLight = light;
	}

	public void execute() {
		theLight.turnOff();
	}
}