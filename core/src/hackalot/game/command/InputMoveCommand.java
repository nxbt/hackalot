package hackalot.game.command;

import java.util.List;

import com.badlogic.gdx.math.Vector2;

import hackalot.game.entity.Character;
import hackalot.game.observer.KeyObservable;
import hackalot.game.observer.KeyObserver;
import hackalot.game.observer.Observable;
import hackalot.game.ref.Ref;
import hackalot.game.value.SimpleValue;
import hackalot.game.value.Value;
import hackalot.game.value.WriteValue;

/**
 * InputMoveCommand Commands a Character to move based on WASD Key Inputs.
 * @author ethan
 *
 */
public class InputMoveCommand implements Command, KeyObserver {
	
	private KeyObservable observable;
	
	private WriteValue<Vector2> direction;

	private MoveCommand move;

	private boolean leftPressed;
	private boolean rightPressed;
	private boolean upPressed;
	private boolean downPressed;
	
	/**
	 * Constructs a new InputMoveCOmmand from a Character to command and a KeyObservable to get updates from.
	 * @param character The Character to command.
	 * @param observable The KeyObservable to get key updates from.
	 */
	public InputMoveCommand(Character character, KeyObservable observable) {
		this.observable = observable;
		Value<Vector2> direction = new SimpleValue<Vector2>();
		this.move = new MoveCommand(character, direction);
		this.direction = direction;
		direction.set(Ref.Direction.CENTER.getVector2());
	}

	/**
	 * Activates this command, while active, this InputMoveCommand will Observe updates from its KeyObservable and
	 * issue commands to its Character based on those updates.
	 */
	@Override
	public void activate() {
		move.activate();
		observable.addObserver(this);
	}

	/**
	 * Deactivates this command, while deactive, this InputMoveCommand will not issue any commands to its Character.
	 */
	@Override
	public void deactivate() {
		move.deactivate();
		observable.removeObserver(this);
	}

	/**
	 * Tells this InputMoveCommand that the Key with keyCode has been pressed down.
	 * @param keyCode The code of the pressed key.
	 */
	@Override
	public void keyDown(int keyCode) {
		switch(keyCode) {
			case Ref.Key.LEFT:
				leftPressed = true;
				updateDireciton();
				break;
			case Ref.Key.RIGHT:
				rightPressed = true;
				updateDireciton();
				break;
			case Ref.Key.UP:
				upPressed = true;
				updateDireciton();
				break;
			case Ref.Key.DOWN:
				downPressed = true;
				updateDireciton();
				break;
			default:
				break;
		}
	}

	/**
	 * Tells this InputMoveCommand that the Key with keyCode has been released.
	 * @param keyCode The code of the released key.
	 */
	@Override
	public void keyUp(int keyCode) {
		switch(keyCode) {
			case Ref.Key.LEFT:
				leftPressed = false;
				updateDireciton();
				break;
			case Ref.Key.RIGHT:
				rightPressed = false;
				updateDireciton();
				break;
			case Ref.Key.UP:
				upPressed = false;
				updateDireciton();
				break;
			case Ref.Key.DOWN:
				downPressed = false;
				updateDireciton();
				break;
			default:
				break;
		}
	}
	
	// updates the direction based on which keys are pressed.
	private void updateDireciton() {
		Vector2 dir = new Vector2();
		if(leftPressed) dir.add(Ref.Direction.LEFT.getVector2());
		if(rightPressed) dir.add(Ref.Direction.RIGHT.getVector2());
		if(upPressed) dir.add(Ref.Direction.UP.getVector2());
		if(downPressed) dir.add(Ref.Direction.DOWN.getVector2());
		direction.set(dir);
	}

}
