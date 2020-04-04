package hackalot.game.command;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;

import hackalot.game.entity.Character;
import hackalot.game.observer.KeyObservable;
import hackalot.game.observer.KeyObserver;
import hackalot.game.ref.Ref;
import hackalot.game.value.SimpleValue;
import hackalot.game.value.Value;

/**
 * InputController controls a Character based on Keyboard input.
 * @author ethan
 *
 */
public class InputController implements InputProcessor, KeyObservable {

	private List<KeyObserver> keyObservers;
	
	/**
	 * Constructs a new InputController to control the given Character.
	 * @param character
	 */
	public InputController(Character character) {
		
		keyObservers = new ArrayList<KeyObserver>();
		
		Value<Vector2> direction = new SimpleValue<Vector2>();
		direction.set(new Vector2());
		
		new KeyPressedCommand(this, Ref.Key.LEFT, new IncreaseVectorCommand(direction, new SimpleValue<Vector2>(Ref.Direction.LEFT.getVector2()))).activate();
		new KeyPressedCommand(this, Ref.Key.RIGHT, new IncreaseVectorCommand(direction, new SimpleValue<Vector2>(Ref.Direction.RIGHT.getVector2()))).activate();
		new KeyPressedCommand(this, Ref.Key.UP, new IncreaseVectorCommand(direction, new SimpleValue<Vector2>(Ref.Direction.UP.getVector2()))).activate();
		new KeyPressedCommand(this, Ref.Key.DOWN, new IncreaseVectorCommand(direction, new SimpleValue<Vector2>(Ref.Direction.DOWN.getVector2()))).activate();
		new KeyPressedCommand(this, Ref.Key.CHANGE_ITEM, new ChangeItemCommand(character)).activate();
		new KeyPressedCommand(this, Ref.Key.INTERACT, () -> character.interact()).activate(); // example of using lambda expression Command

		new MoveCommand(character, direction).activate();
		
		//new InputMoveCommand(character, this).activate();

		Gdx.input.setInputProcessor(this);
	}

	/**
	 * Add o to the list of KeyObservers to update.
	 * @param o
	 */
	@Override
	public void addObserver(KeyObserver o) {
		keyObservers.add(o);
	}

	/**
	 * Remove o from the list of KeyObservers to update.
	 * @param o
	 */
	@Override
	public void removeObserver(KeyObserver o) {
		keyObservers.remove(o);
	}

	/**
	 * Called by LibGDX when a key is pressed down.
	 * **DO NOT CALL**
	 */
	@Override
	public boolean keyDown(int keycode) {
		keyObservers.forEach(x -> x.keyDown(keycode));
		return true;
	}


	/**
	 * Called by LibGDX when a key is released down.
	 * **DO NOT CALL**
	 */
	@Override
	public boolean keyUp(int keycode) {
		keyObservers.forEach(x -> x.keyUp(keycode));
		return true;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
