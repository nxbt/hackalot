package hackalot.game.value;

/**
 * A Value is something that can be read, written, and observed.
 * 
 * Should be passed as a WriteValue<T> or a ReadValue<T> when only
 * reading or writing is required.
 * 
 * @author ethan
 *
 * @param <T> The type of the value.
 */
public interface Value<T> extends WriteValue<T>, ReadValue<T> {
	
}
