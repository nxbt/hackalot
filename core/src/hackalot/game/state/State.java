package hackalot.game.state;

import hackalot.game.Drawable;
import hackalot.game.Drawer;
import hackalot.game.Updatable;
import hackalot.game.Updater;

/**
 * Abstract class for a game state, such as the main menu or game-play
 */
public abstract class State implements Updatable, Drawable {

	/**
	 * Called when this state is no longer needed and resources need to be released
	 */
	public abstract void dispose();

	/**
	 * called when the window is resized
	 * @param width The new window width
	 * @param height The new window height
	 */
	public abstract void resize( int width, int height );
}
