package hackalot.game.crafting;

import hackalot.game.map.Building;
import hackalot.game.map.Tile;

public class TileMatcher {
	
	private String name;
	private Item item;
	private Building building;
	
	public boolean matches(Tile tile) {
		return name.equals(tile.getName())
				&& item.equals(tile.getItem())
				&& building.equals(tile.getBuilding());
	} 
	

}
