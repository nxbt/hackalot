package hackalot.game.state;

import hackalot.game.Drawable;
import hackalot.game.Updatable;
import com.badlogic.gdx.utils.Disposable;

/**
 * Abstract class for a game state, such as the main menu or game-play
 */
public abstract class State implements Updatable, Drawable, Disposable {

	/**
	 * called when the window is resized
	 * @param width The new window width
	 * @param height The new window height
	 */
	public abstract void resize( int width, int height );
}
