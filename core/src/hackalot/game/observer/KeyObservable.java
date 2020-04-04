package hackalot.game.observer;

/**
 * A KeyDownObservable is something that sends messages when a key is pressed.
 * @author ethan
 *
 */
public interface KeyObservable {

	abstract public void addObserver(KeyObserver o);
	abstract public void removeObserver(KeyObserver o);
	
}
