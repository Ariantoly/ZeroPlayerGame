
public class Inventory extends Bag{
	private Integer qty, price;

	public Inventory(String name) {
		super(name);
		randomize();
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public void randomize() {
		price = rand.nextInt(5) + 1;
		qty = 1;
		
	}
	

}
