
public class Player {
	protected String name, clan, playerClass;
	protected Integer level, total;
	protected Integer[] stat = new Integer[6];

	public Player(String name, String clan, String playerClass, Integer[] stat) {
		init(name, clan, playerClass, stat);
	}
	
	private void init(String name, String clan, String playerClass, Integer[] stat){
		this.name = name;
		this.clan = clan;
		this.playerClass = playerClass;
		this.stat = stat;
		level = 1;
		total = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClan() {
		return clan;
	}

	public void setClan(String clan) {
		this.clan = clan;
	}

	public String getPlayerClass() {
		return playerClass;
	}

	public void setPlayerClass(String playerClass) {
		this.playerClass = playerClass;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer[] getStat() {
		return stat;
	}

	public void setStat(Integer[] stat) {
		this.stat = stat;
	}
		
}
