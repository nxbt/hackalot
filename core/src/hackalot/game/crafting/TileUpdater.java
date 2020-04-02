package hackalot.game.crafting;

import hackalot.game.item.Item;
import hackalot.game.map.BuildingTile;
import hackalot.game.map.Tile;

public class TileUpdater {
	
	private String name;
	private Item item;
	private BuildingTile buildingTile;
	
	public TileUpdater(String name, Item item, BuildingTile buildingTile) {
		this.name = name;
		this.item = item;
		this.buildingTile = buildingTile;
	}
	
	public void update(Tile tile) {
		tile.setName(name);
		tile.setItem(item);
		tile.setBuildingTile(buildingTile);
	}
	
}
