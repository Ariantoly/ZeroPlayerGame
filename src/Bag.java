import java.util.Random;

public abstract class Bag {
	protected String name;
	protected Random rand = new Random();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public abstract void randomize();

	public Bag(String name) {
		super();
		this.name = name;
	}
	
}
