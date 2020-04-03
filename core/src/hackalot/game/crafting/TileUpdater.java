package hackalot.game.crafting;

import hackalot.game.item.Item;
import hackalot.game.map.BuildingTile;
import hackalot.game.map.MapUpdateReceiver;
import hackalot.game.map.MapUpdateSender;

public class TileUpdater implements MapUpdateSender {
	
	private String name;
	private Item item;
	private BuildingTile buildingTile;
	
	private MapUpdateReceiver receiver;
	
	/**
	 * Constructs a new TileUpdater and tells it how to update Tiles.
	 * @param name The name to update tiles to.
	 * @param item The item to update tiles to.
	 * @param buildingTile The buildingTile to update tiles to.
	 */
	public TileUpdater(String name, Item item, BuildingTile buildingTile) {
		this.name = name;
		this.item = item;
		this.buildingTile = buildingTile;
	}
	
	/**
	 * Applies this TileUpdater to the tile at (x, y)
	 * @param x The x position of the tile to update.
	 * @param y The y position of the tile to update.
	 */
	public void update(int x, int y) {
		getMapUpdateReceiver().setName(x, y, name);
		getMapUpdateReceiver().setItem(x, y, item);
		getMapUpdateReceiver().setBuildingTile(x, y, buildingTile);
	}


	/**
	 * Sets the MapUpdateReceiver that should receive updates from this TileUpdater.
	 * @param receiver The new receiver.
	 */
	@Override
	public void setReceiver(MapUpdateReceiver receiver) {
		this.receiver = receiver;
		
	}

	
	/**
	 * Gets the MapUpdateReceiver that is Receiving updates from this TileUpdater.
	 * @return The MapUpdateReceiver.
	 */
	@Override
	public MapUpdateReceiver getMapUpdateReceiver() {
		return receiver;
	}
	
}
