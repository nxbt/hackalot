package hackalot.game.observer;

/**
 * An Observer is something that waits for an incoming message from an Observable.
 * 
 * You can think of it almost as watching the Observable.
 * 
 * @author ethan
 *
 * @param <O> The Argument of the incoming message.
 */
public interface Observer<O> {

	/**
	 * Called to signify an incoming message.
	 * @param o The message.
	 */
	abstract public void update(O o);

}