package hackalot.game.value;

public class SimpleValue<T> implements Value<T> {
	
	private T t;

	@Override
	public void set(T t) {
		this.t = t;

	}

	@Override
	public T get() {
		return t;
	}

}
