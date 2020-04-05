package hackalot.game.value;

import java.util.ArrayList;
import java.util.List;

import hackalot.game.observer.Observer;

/**
 * SimpleValue stores a single instance of some type, and allows it to be
 * read, written, and observed.
 * 
 * @author ethan
 *
 * @param <T>
 */
public class SimpleValue<T> implements Value<T> {
	
	private List<Observer<ReadValue<T>>> observables;
	
	private T t;
	
	/**
	 * Creates a new SimpleValue. T will be inialized to null.
	 */
	public SimpleValue() {
		observables = new ArrayList<Observer<ReadValue<T>>>();
	}
	
	/**
	 * Creates a new SimpleValue. T will be inialized to the given value.
	 * @param t The starting value of T.
	 */
	public SimpleValue(T t) {
		observables = new ArrayList<Observer<ReadValue<T>>>();
		this.t = t;
	}

	/**
	 * Sets the value of this SimpleValue's T to t.
	 * @param t The new value.
	 */
	@Override
	public void set(T t) {
		this.t = t;
		observables.forEach(x -> x.update(this));

	}

	/**
	 * Gets the value of this SimpleValue's T.
	 * @return The current value.
	 */
	@Override
	public T get() {
		return t;
	}

	/**
	 * Add o to the list of Observers to update when the value changes.
	 * @param o The Observer<ReadValue<T>> to add.
	 */
	@Override
	public void addObserver(Observer<ReadValue<T>> o) {
		observables.add(o);
	}

	/**
	 * Remove o from the list of Observers to update when the value changes.
	 * @param o The Observer<ReadValue<T>> to remove.
	 */
	@Override
	public void removeObserver(Observer<ReadValue<T>> o) {
		observables.remove(o);
		
	}

}
