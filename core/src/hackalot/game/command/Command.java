package hackalot.game.command;

/**
 * A command is something that can be active or not.
 * @author ethan
 *
 */
public interface Command {
	
	/**
	 * Activates this command.
	 */
	abstract public void activate();
	
	/**
	 * Deactivates this command.
	 */
	default public void deactivate() {}; // default so that Command can be a Functional interface and allow lambda expr.
}
