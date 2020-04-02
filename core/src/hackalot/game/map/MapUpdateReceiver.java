package hackalot.game.map;

import hackalot.game.crafting.Blueprint;
import hackalot.game.item.Item;

/**
 * A MapUpdateReceiver receives to updates from a MapUpdateSender.
 * @author ethan
 */
public interface MapUpdateReceiver {

	/**
	 * Sets the item located at (x, y) to item.
	 * @param x The x coordinate on the map
	 * @param y The y coordinate on the map
	 * @param item The item to set.
	 */
	abstract public void setItem(int x, int y, Item item);

	/**
	 * Sets the name of the tile located at (x, y) to name.
	 * @param x The x coordinate on the map
	 * @param y The y coordinate on the map
	 * @param name The new name of the tile.
	 */
	abstract public void setName(int x, int y, String name);

	/**
	 * Sets the BuildingTile of the tile located at (x, y) to buildingTile.
	 * @param x The x coordinate on the map.
	 * @param y The y coordinate on the map.
	 * @param buildingTile The new buildingTile.
	 */
	abstract public void setBuildingTile(int x, int y, BuildingTile buildingTile);

	/**
	 * TODO: should this be here? I needed it to get PlayState to work.
	 * TODO: if this should be here, write a javadoc header
	 * @param x
	 * @param y
	 * @param item
	 * @return
	 */
	Blueprint getBuildableBlueprint( int x, int y, Item item );
}
