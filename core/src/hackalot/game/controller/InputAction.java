package hackalot.game.controller;

/**
 * abstract InputAction class, represents a type of input to a controller
 * @author Brendan
 */
public abstract class InputAction {
	protected boolean active;

	public boolean getActive() {
		boolean retVal = active;
		afterTick();
		return retVal;
	}

	public abstract void risingEdge();
	public abstract void fallingEdge();

	protected abstract void afterTick();
}
