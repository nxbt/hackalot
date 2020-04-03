package hackalot.game.state;

import com.badlogic.gdx.utils.Disposable;
import hackalot.game.Drawable;
import hackalot.game.Updatable;

/**
 * Manages the current state of the game, from main menu to in-game
 * @author Brendan
 */
public class StateManager implements Updatable, Drawable, Disposable, StateUpdateReceiver {

	private State state;

	/**
	 * Default constructor
	 */
	public StateManager() {
		this.state = new PlayState();
	}

	/**
	 * Changes the current game state to a new state
	 * @param state The state to change to
	 */
	@Override
	public void changeState( State state ) {
		this.state.dispose();
		this.state = state;

		// Ensures the receiver for the new state is this StateManager
		this.state.setReceiver( this );
	}

	/**
	 * Called when the window is resized, passes call to current state
	 * @param width The new window width
	 * @param height The new window height
	 */
	public void resize( int width, int height ) {
		state.resize( width, height );
	}

	/**
	 * Called when the current state needs to be disposed
	 */
	@Override
	public void dispose() {
		state.dispose();
	}

	/**
	 * Updates the current state
	 */
	@Override
	public void update() {
		state.update();
	}

	/**
	 * Draws the current state
	 */
	@Override
	public void draw() {
		state.draw();
	}
}
