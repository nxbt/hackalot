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

public class InputMoveCommand implements Command, KeyObserver, Observable<MoveCommand> {
	
	private KeyObservable observable;
	
	private WriteValue<Vector2> direction;
	
	private List<MoveCommand> observers;

	private MoveCommand move;

	private boolean leftPressed;
	private boolean rightPressed;
	private boolean upPressed;
	private boolean downPressed;
	
	public InputMoveCommand(KeyObservable observable, Character character) {
		this.observable = observable;
		Value<Vector2> direction = new SimpleValue<Vector2>();
		this.move = new MoveCommand(character, direction);
		this.direction = direction;
		direction.set(Ref.Direction.CENTER.getVector2());
	}

	@Override
	public void activate() {
		move.activate();
		observable.addObserver(this);
	}

	@Override
	public void deactivate() {
		move.deactivate();
		observable.removeObserver(this);
	}

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
	
	private void updateDireciton() {
		Vector2 dir = new Vector2();
		if(leftPressed) dir.add(Ref.Direction.LEFT.getVector2());
		if(rightPressed) dir.add(Ref.Direction.RIGHT.getVector2());
		if(upPressed) dir.add(Ref.Direction.UP.getVector2());
		if(downPressed) dir.add(Ref.Direction.DOWN.getVector2());
		direction.set(dir);
	}

	@Override
	public void addObserver(MoveCommand o) {
		this.observers.add(o);
	}

	@Override
	public void removeObserver(MoveCommand o) {
		this.observers.remove(o);
	}

}
