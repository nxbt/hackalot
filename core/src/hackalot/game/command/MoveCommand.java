package hackalot.game.command;

import com.badlogic.gdx.math.Vector2;

import hackalot.game.entity.Character;
import hackalot.game.observer.Observer;
import hackalot.game.value.ReadValue;

public class MoveCommand implements Command, Observer<ReadValue<Vector2>> {

	private Character character;
	private ReadValue<Vector2> direction;
	
	public MoveCommand(Character character, ReadValue<Vector2> direction) {
		this.character = character;
		this.direction = direction;
	}

	@Override
	public void activate() {
		direction.addObserver(this);
	}
	
	@Override
	public void deactivate() {
		direction.addObserver(this);
	}

	@Override
	public void update(ReadValue<Vector2> o) {
		character.setMoveDirection(direction.get());
	}

}
