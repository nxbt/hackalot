package hackalot.game.map;

public abstract class Building implements Craftable {
	private int HP;
	
	public void setHealth(int HP) {
		this.HP = HP;
	}
	
	public int getHealth() {
		return HP;
	}
}
