package week_1.gof_patterns.structural;

public class Facade {
	public static void main(String[] args) {
		
		Computer computer = new Computer();
	    computer.startComputer();
		
	}
}

class CPU {
	public void freeze() {
	}

	public void jump(long position) {
	}

	public void execute() {
	}
}

class Memory {
	public void load(long position, byte[] data) {
	}
}

class HardDrive {
	public byte[] read(long lba, int size) {
		return null;
	}
}

class Computer {
	private CPU cpu;
	private Memory memory;
	private HardDrive hardDrive;

	public Computer() {
		this.cpu = new CPU();
		this.memory = new Memory();
		this.hardDrive = new HardDrive();
	}

	public void startComputer() {
		cpu.freeze();
		memory.load(100, hardDrive.read(100, 100));
		cpu.jump(100);
		cpu.execute();
	}
}