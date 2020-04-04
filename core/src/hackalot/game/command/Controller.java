package hackalot.game.command;

import hackalot.game.activater.Activatable;

/**
 * A command is something that can be active or not.
 * @author ethan
 *
 */
public interface Controller extends Activatable {
	
	/**
	 * Activates this command.
	 */
	abstract public void activate();
	
	/**
	 * Deactivates this command.
	 */
	default public void deactivate() {}; // default so that Command can be a Functional interface and allow lambda expr.
}
