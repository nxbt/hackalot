package hackalot.game.crafting;

import hackalot.game.item.Item;
import hackalot.game.map.BuildingTile;
import hackalot.game.map.Tile;

public class TileMatcher {
	
	private String name;
	private Item item;
	private BuildingTile buildingTile;
	
	public TileMatcher(String name, Item item, BuildingTile buildingTile) {
		this.name = name;
		this.item = item;
		this.buildingTile = buildingTile;
	}
	
	public boolean matches(Tile tile) {
		return (name == null || name.equals(tile.getName()))
				&& (item == null || item.equals(tile.getItem()))
				&& (buildingTile == null || (buildingTile.equals(tile.getBuildingTile()) && !tile.getBuildingTile().isDestroyed()));
	} 
	

}
