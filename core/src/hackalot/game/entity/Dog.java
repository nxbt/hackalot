package hackalot.game.entity;

import com.badlogic.gdx.math.Vector2;

/**
 * Can RECEIVE items from a player, CANNOT pickup. Can move around, and can drop items onto the tile ahead.
 * @author HANHAN
 *
 */
public class Dog extends Animal {
	
	
	
	public Dog(Vector2 position, Vector2 velocity) {
		super(position, velocity);
		// TODO Auto-generated constructor stub
		
	}

	public Dog(Vector2 position, Vector2 velocity, String name, int HP) {
		super(position, velocity, name, HP);
		// TODO Auto-generated constructor stub
	}
}
