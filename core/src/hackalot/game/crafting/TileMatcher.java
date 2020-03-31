package hackalot.game.crafting;

import hackalot.game.item.Item;
import hackalot.game.map.BuildingTile;
import hackalot.game.map.Tile;

public class TileMatcher {
	
	private String name;
	private Item item;
	private BuildingTile building;
	
	public boolean matches(Tile tile) {
		return name.equals(tile.getName())
				&& item.equals(tile.getItem())
				&& building.equals(tile.getBuildingTile());
	} 
	

}
