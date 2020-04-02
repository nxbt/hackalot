package hackalot.game.state;

/**
 * Interface for classes that can change a StateUpdateReceiver
 * @author Brendan
 */
public interface StateUpdateSender {
	/**
	 * Sets the StateUpdateReceiver
	 * @param stateUpdateReceiver The new StateUpdateReceiver
	 */
	void setReceiver( StateUpdateReceiver stateUpdateReceiver );

	/**
	 * Gets a reference to the StateUpdateReceiver
	 * @return The StateUpdateReceiver tied to this
	 */
	StateUpdateReceiver getReceiver();
}
