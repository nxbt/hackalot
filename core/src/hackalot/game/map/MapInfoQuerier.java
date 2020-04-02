package hackalot.game.map;

/**
 * A MapInfoQuerier sends Queries to a MapInfoProvider.
 * @author ethan
 */
public interface MapInfoQuerier {
	
	/**
	 * Sets the MapInfoProvider that should respond to Queries from this MapInfoQuerier.
	 * @param provider The new MapInfoProvider.
	 */
	abstract public void setProvider(MapInfoProvider provider);
	
	/**
	 * Gets the MapInfoProvider that is responding to Queries from this MapInfoQuerier.
	 * @return The MapInfoProvider
	 */
	abstract public MapInfoProvider getMapInfoProvider();

}
