package hackalot.game.value;

import hackalot.game.observer.Observable;
import hackalot.game.observer.Observer;

public interface ReadValue<T> extends Observable<Observer<ReadValue<T>>> {
	abstract public T get();
}
