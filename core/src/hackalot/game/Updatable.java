package hackalot.game;

/**
 * Interface for objects that process game logic every update tick
 *
 * @author Brendan
 */
public interface Updatable {

	/**
	 * Called when the object is updated
	 */
	public abstract void update();
}
