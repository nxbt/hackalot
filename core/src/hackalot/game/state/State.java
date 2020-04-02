package hackalot.game.state;

import hackalot.game.Drawable;
import hackalot.game.Updatable;
import com.badlogic.gdx.utils.Disposable;

/**
 * Abstract class for a game state, such as the main menu or game-play
 */
public abstract class State implements Updatable, Drawable, Disposable, StateUpdateSender {

	private StateUpdateReceiver stateUpdateReceiver;

	/**
	 * called when the window is resized
	 * @param width The new window width
	 * @param height The new window height
	 */
	public abstract void resize( int width, int height );

	/**
	 * Sets the StateUpdateReceiver for this object
	 * @param receiver The new StateUpdateReceiver
	 */
	@Override
	public void setReceiver( StateUpdateReceiver receiver ) {
		this.stateUpdateReceiver = receiver;
	}

	/**
	 * Gets a reference to the StateUpdateReceiver this object has
	 * @return The reference to the StateUpdateReceiver
	 */
	@Override
	public StateUpdateReceiver getStateUpdateReceiver() {
		return this.stateUpdateReceiver;
	}
}
