package hackalot.game.command;

import java.util.function.Consumer;

public class LambdaController<T> implements Controller {
	
	private T t;
	private Consumer<T> consumer;
	
	public LambdaController(T t, Consumer<T> consumer) {
		this.t = t;
		this.consumer = consumer;
	}

	@Override
	public void activate() {
		consumer.accept(t);
	}

	@Override
	public void deactivate() {

	}

	@Override
	public boolean isActive() {
		return false;
	}

}
