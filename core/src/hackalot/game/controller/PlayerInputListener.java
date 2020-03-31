package hackalot.game.controller;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

import static hackalot.game.ref.Ref.R;

/**
 * Listens for input that should be captured by the player character
 * Currently only works for keyboard controls TODO: implement ControllerListener
 * @author Brendan
 */
public class PlayerInputListener extends InputListener {

	private PlayerController controller;
	private Vector2 direction;

	public PlayerInputListener( PlayerController controller ) {
		this.controller = controller;

		direction = new Vector2();
	}

	public Vector2 getDirection() {
		return direction;
	}

	/* Direction in this class is updated as a key is pressed, but we only want to poll controller direction*/
	private void updateDirection( int x, int y ) {
		direction.x += x;
		direction.y += y;
	}

	/** Called when a key goes down. When true is returned, the event is {@link Event#handle() handled}. */
	@Override
	public boolean keyDown ( InputEvent event, int keycode) {
		if( keycode == R.key.up ) {
			updateDirection( 0, 1 );
			return true;
		}
		if( keycode == R.key.left ) {
			updateDirection( -1, 0 );
			return true;
		}
		if( keycode == R.key.down ) {
			updateDirection( 0, -1 );
			return true;
		}
		if( keycode == R.key.right ) {
			updateDirection( 1, 0 );
			return true;
		}

		if( keycode == R.key.interact ) {
			controller.risingInputAction( "interact" );
			return true;
		}

		return false;
	}

	/** Called when a key goes up. When true is returned, the event is {@link Event#handle() handled}. */
	@Override
	public boolean keyUp (InputEvent event, int keycode) {
		if( keycode == R.key.up ) {
			updateDirection( 0, -1 );
			return true;
		}
		if( keycode == R.key.left ) {
			updateDirection( 1, 0 );
			return true;
		}
		if( keycode == R.key.down ) {
			updateDirection( 0, 1 );
			return true;
		}
		if( keycode == R.key.right ) {
			updateDirection( -1, 0 );
			return true;
		}

		if( keycode == R.key.interact ) {
			controller.fallingInputAction( "interact" );
			return true;
		}

		return false;
	}

}
