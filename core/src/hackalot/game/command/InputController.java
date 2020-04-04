package hackalot.game.command;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

import hackalot.game.entity.Character;
import hackalot.game.observer.KeyObservable;
import hackalot.game.observer.KeyObserver;

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
		new InputMoveCommand(character, this).activate();

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
