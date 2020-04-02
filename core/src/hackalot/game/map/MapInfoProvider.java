package hackalot.game.map;

/**
 * A MapInfoProvider responds to Queries from a MapInfoQuerier.
 * @author ethan
 */
public interface MapInfoProvider {
	
	/**
	 * Gets the Tile at (x, y).
	 * @param x The x coordinate on the map.
	 * @param y The y coordinate on the map.
	 * @return The Tile at the (x, y) location.
	 */
	abstract public Tile getTile(int x, int y);
}
