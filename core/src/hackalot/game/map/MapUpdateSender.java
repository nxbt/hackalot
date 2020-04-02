package hackalot.game.map;

/**
 * A MapUpdateSender sends updates to a MapUpdateReceiver.
 * @author ethan
 */
public interface MapUpdateSender {

	/**
	 * Sets the MapUpdateReceiver that should receive updates from this MapUpdateSender.
	 * @param receiver The new receiver.
	 */
	abstract public void setReciever(MapUpdateReceiver receiver);
	
	/**
	 * Gets the MapUpdateReceiver that is Receiving updates from this MapUpdateSender.
	 * @return The MapUpdateReceiver.
	 */
	abstract public MapUpdateReceiver getMapUpdateReceiver();
	
}
