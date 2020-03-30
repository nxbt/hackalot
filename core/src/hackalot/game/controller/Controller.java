package hackalot.game.controller;

import com.badlogic.gdx.math.Vector2;

import java.util.HashMap;
import java.util.Map;

/**
 * abstract character controller
 *
 * @author Brendan
 */
public abstract class Controller {

	protected Vector2 direction; // direction of input limited to length <= 1
	protected Map<String, InputAction> inputActionMap;

	public Controller() {
		direction = new Vector2();
		inputActionMap = new HashMap<>();
	}

	public abstract void updateDirection();
	public abstract void updateInputActionMap();

	public void addInputAction( String name, InputAction action ) {
		inputActionMap.put( name, action );
	}

	public boolean getInputAction( String name ) {
		return inputActionMap.get( name ).getActive();
	}

	/**
	 * Processes new state of inputs
	 */
	public final void tick() {
		updateDirection();
		updateInputActionMap();

		direction.limit( 1 );
	}

	public final Vector2 getDirection() {
		return direction;
	}
}
