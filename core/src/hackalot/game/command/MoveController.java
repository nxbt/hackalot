package hackalot.game.command;

import com.badlogic.gdx.math.Vector2;

import hackalot.game.entity.Character;
import hackalot.game.observer.Observer;
import hackalot.game.ref.Ref;
import hackalot.game.value.ReadValue;

/**
 * MoveCommand commands a character to move along a certain vector.
 * @author ethan
 *
 */
public class MoveController implements Controller, Observer<ReadValue<Vector2>> {

	private Character character;
	private ReadValue<Vector2> direction;
	private boolean active;
	
	/**
	 * Constructs a new MoveCommand from a Character to command and a Vector2 to move along.
	 * @param character The Character to command
	 * @param direction The direction the character should move along. While active, changes to the
	 * direction will be reflected in the commands given to the Character.
	 */
	public MoveController(Character character, ReadValue<Vector2> direction) {
		this.character = character;
		this.direction = direction;
	}

	/**
	 * Activates this command, while active, MoveCommand will command its Character to move along its Vector2.
	 */
	@Override
	public void activate() {
		direction.addObserver(this);
		this.active = true;
	}


	/**
	 * Deactivates this command, while deactive MoveCommand will not issue any commands to its Character.
	 */
	@Override
	public void deactivate() {
		direction.addObserver(this);
		character.setMoveDirection(Ref.Direction.CENTER.getVector2());
		this.active = false;
	}
	
	@Override
	public boolean isActive() {
		return active;
	}

	/**
	 * Tells this MoveCommand that the direction Vector2 has been updated. If this MoveCommand is active, then
	 * it will issue a new command to its Character with the new Direction.
	 */
	@Override
	public void update(ReadValue<Vector2> o) {
		System.out.println("Vector2: " + direction.get());
		character.setMoveDirection(direction.get());
	}

}
