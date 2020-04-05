package hackalot.game.value;

import hackalot.game.observer.Observable;
import hackalot.game.observer.Observer;

/**
 * A readValue is a value that can be read and observed.
 * @author ethan
 *
 * @param <T> The Type of the value.
 */
public interface ReadValue<T> extends Observable<Observer<ReadValue<T>>> {
	
	/**
	 * Gets the value of this ReadValue's T.
	 * @return The value of this ReadValue.
	 */
	abstract public T get();
}
