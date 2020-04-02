package hackalot.game;

import java.util.Iterator;

/**
 * Interface for objects that hold collections of drawable objects
 * @param <D> The type of drawable this object draws
 * @author Brendan
 */
public interface Drawer<D extends Drawable> {
	/**
	 * Adds a drawable object to this drawer
	 * @param drawable The drawable object to add
	 */
	public abstract void addDrawable( D drawable );

	/**
	 * Removes a drawable object from this drawer
	 * @param drawable The drawable object to remove
	 * @return True if the object was successfully removed
	 */
	public abstract boolean removeDrawable( D drawable);

	/**
	 * Gets an iterator over the drawables
	 * @return An iterator over the collection of drawables
	 */
	public abstract Iterator<D> getDrawables();
}
