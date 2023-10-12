package ex2student;

public class Runner {
	private final String name; // not null
	private final int lapTime;

	public Runner(String name) {
		this(name, 0);
	}

	public Runner(String name, int lapTime) {
		this.name = name;
		this.lapTime = lapTime;
	}

	@Override
	public String toString() {
		return String.format("Runner[%s, %d sec]", name, lapTime);
	}

	public String getName() {
		return name;
	}

	public int getLapTime() {
		return lapTime;
	}

}
