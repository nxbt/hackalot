package hackalot.game.state;

/**
 * Interface for classes that can change a StateUpdateReceiver
 * @author Brendan
 */
public interface StateUpdateSender {
	/**
	 * Sets the StateUpdateReceiver
	 * @param receiver The new StateUpdateReceiver
	 */
	void setReceiver( StateUpdateReceiver receiver );

	/**
	 * Gets a reference to the StateUpdateReceiver
	 * @return The StateUpdateReceiver tied to this
	 */
	StateUpdateReceiver getStateUpdateReceiver();
}
