package hackalot.game.state;

/**
 * Interface for a class that receives updates to the state
 * @author Brendan
 */
public interface StateUpdateReceiver {
	/**
	 * Changes the current state
	 * @param state The new state
	 */
	void changeState( State state );
}
