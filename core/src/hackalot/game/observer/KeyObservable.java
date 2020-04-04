package hackalot.game.observer;

/**
 * A KeyDownObservable is something that sends messages when a key is pressed.
 * @author ethan
 *
 */
public interface KeyObservable {


	/**
	 * Add o to the list of KeyObservers to update.
	 * @param o
	 */
	abstract public void addObserver(KeyObserver o);

	/**
	 * Remove o from the list of KeyObservers to update.
	 * @param o
	 */
	abstract public void removeObserver(KeyObserver o);
	
}
