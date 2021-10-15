
public class Equipment extends Bag{
	private String[] type = {"Weapon", "Shield", "Helm", "Body Armor"};
	private String equipType;
	private Integer price;

	public Equipment(String name) {
		super(name);
		randomize();
	}
	
	public String getEquipType() {
		return equipType;
	}

	public void setEquipType(String equipType) {
		this.equipType = equipType;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public void randomize(){
		price = rand.nextInt(21) + 20;
		equipType = type[rand.nextInt(4)];
	}

}
