package hackalot.game.command;

import com.badlogic.gdx.math.Vector2;

import hackalot.game.observer.Observer;
import hackalot.game.value.ReadValue;
import hackalot.game.value.Value;

/**
 * The IncreaseVectorCommand, increases a given Value<Vector2> by a given amount while active.
 * @author ethan
 */
public class IncreaseVectorController implements Controller, Observer<ReadValue<Vector2>> {

	private Value<Vector2> value;
	private Vector2 curAmount;
	private ReadValue<Vector2> amount;
	
	/**
	 * Constructs a new IncreaseVectorCommand from a Value<Vetor2> to update and a ReadValue<Vector2> to update by.
	 * @param value The vector to update.
	 * @param amount The amount to update the vector by.
	 */
	public IncreaseVectorController(Value<Vector2> value, ReadValue<Vector2> amount) {
		this.value = value;
		this.amount = amount;
		curAmount = new Vector2();
	}

	/**
	 * Activate this IncreaseVectorCommand. While active, value will be increased by amount.
	 */
	@Override
	public void activate() {
		this.value.set(this.value.get().add(this.amount.get()));
		curAmount = new Vector2(this.amount.get());
		amount.addObserver(this);
	}

	/**
	 * Deactivate this IncreaseVectorCommand. While active, value will not be affected by this IncreaseVectorCommand.
	 */
	@Override
	public void deactivate() {
		amount.removeObserver(this);
		this.value.set(this.value.get().sub(this.curAmount));
		curAmount = new Vector2();
	}

	/**
	 * Tells this IncreaseVectorCommand that the amount it should change the vector by has changed.
	 */
	@Override
	public void update(ReadValue<Vector2> o) {
		this.deactivate();
		this.activate();
	}

}
