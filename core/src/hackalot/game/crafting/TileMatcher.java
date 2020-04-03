package hackalot.game.crafting;

import hackalot.game.item.Item;
import hackalot.game.map.BuildingTile;
import hackalot.game.map.MapInfoProvider;
import hackalot.game.map.MapInfoQuerier;
import hackalot.game.map.Tile;

/**
 * A tile matcher consists of some criteria that either matches or doesn't match a Tile.
 * @author ethan
 *
 */
public class TileMatcher implements MapInfoQuerier {
	
	private String name;
	private Item item;
	private BuildingTile buildingTile;
	
	private MapInfoProvider provider;
	
	/**
	 * Constructs a new TileMatcher and tells it what to match.
	 * @param name Only match tiles with this name, if null, matches tiles regardless of name.
	 * @param item Only match tiles with this item, if null, matches tiles regardless of item.
	 * @param buildingTile Only match tiles with this buildingTile, if null, matches tiles regardless of buildingTile.
	 */
	public TileMatcher(String name, Item item, BuildingTile buildingTile) {
		this.name = name;
		this.item = item;
		this.buildingTile = buildingTile;
	}
	
	/**
	 * Checks if this TileMatcher matches the Tile at (x, y).
	 * @param x The x coordinate of the tile to match.
	 * @param y The y coordinate of the tile to match.
	 * @return True if the Tile matches.
	 */
	public boolean matches(int x, int y) {
		Tile tile = getMapInfoProvider().getTile(x, y);
		return (name == null || name.equals(tile.getName()))
				&& (item == null || item.equals(tile.getItem()))
				&& (buildingTile == null || (buildingTile.equals(tile.getBuildingTile()) && !tile.getBuildingTile().isDestroyed()));
	}
	
	/**
	 * Sets the MapInfoProvider that should respond to Queries from this TileMatcher.
	 * @param provider The new MapInfoProvider.
	 */
	@Override
	public void setProvider(MapInfoProvider provider) {
		this.provider = provider;
	}
	
	/**
	 * Gets the MapInfoProvider that is responding to Queries from this TileMatcher.
	 * @return The MapInfoProvider
	 */
	@Override
	public MapInfoProvider getMapInfoProvider() {
		return provider;
	} 
	

}
