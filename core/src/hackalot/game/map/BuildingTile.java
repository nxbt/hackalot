package hackalot.game.map;

import hackalot.game.item.Item;

//single tile of a building
public class BuildingTile {
	private Building building; // the building this tile is a part of. Circular dependency is not good.  Maybe use MVP Pattern?
	private int HP;
	private Item dropItem; // item that should drop when this buildingTile is deconstructed.
	private boolean destroyed;
	
	public BuildingTile() {
		destroyed = false;
	}
	
	private void destroy() {
		destroyed = true;
	}
	
	public boolean isDestroyed() {
		return destroyed;
	}
	
	public void setHealth(int HP) {
		this.HP = HP;
		if(this.HP < 1) destroy();
	}
	
	public int getHealth() {
		return HP;
	}
	
}
