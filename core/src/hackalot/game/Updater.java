package hackalot.game;

import java.util.Collection;
import java.util.Iterator;

/**
 * Interface for objects that hold collections of updatable objects
 * @param <U> The type of updatable this object updates
 * @author Brendan
 */
public interface Updater<U extends Updatable> {
	/**
	 * Adds an updatable object to this updater
	 * @param updatable The updatable object to add
	 */
	public abstract void addUpdatable( U updatable );

	/**
	 * Removes an updatable object from this updater
	 * @param updatable The updatable object to remove
	 * @return True if the object was successfully removed
	 */
	public abstract boolean removeUpdatable( U updatable );

	/**
	 * Gets an iterator over the updatables
	 * @return An iterator over the collection of updatables
	 */
	public abstract Iterator<U> getUpdatables();
}
