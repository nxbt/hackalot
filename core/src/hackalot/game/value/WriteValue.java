package hackalot.game.value;

/**
 * A WriteValue is a value that can be written.
 * @author ethan
 *
 * @param <T> The Type of the value.
 */
public interface WriteValue<T> {
	
	/**
	 * Sets the value of this WriteValue's T to t.
	 * @param t The new value.
	 */
	abstract public void set(T t);
}
