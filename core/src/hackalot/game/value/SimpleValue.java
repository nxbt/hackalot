package hackalot.game.value;

import java.util.ArrayList;
import java.util.List;

import hackalot.game.observer.Observer;

public class SimpleValue<T> implements Value<T> {
	
	private List<Observer<ReadValue<T>>> observables;
	
	private T t;
	
	public SimpleValue() {
		observables = new ArrayList<Observer<ReadValue<T>>>();
	}

	@Override
	public void set(T t) {
		this.t = t;
		observables.forEach(x -> x.update(this));

	}

	@Override
	public T get() {
		return t;
	}

	@Override
	public void addObserver(Observer<ReadValue<T>> o) {
		observables.add(o);
	}

	@Override
	public void removeObserver(Observer<ReadValue<T>> o) {
		observables.remove(o);
		
	}

}
