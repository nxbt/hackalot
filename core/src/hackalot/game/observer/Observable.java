package hackalot.game.observer;

/**
 * An Observable is something that sends messages to Observers.
 * When something changes with the state of an Observer, it sends a message to
 * all of its Observers via the update() method.
 * @author ethan
 * 
 */
public interface Observable<O> {

	/**
	 * Add o to the list of Observers to update.
	 * @param o
	 */
	abstract public void addObserver(O o);

	/**
	 * Remove o from the list of Observers to update.
	 * @param o
	 */
	abstract public void removeObserver(O o);

}
