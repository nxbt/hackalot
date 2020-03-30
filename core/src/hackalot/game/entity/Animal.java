package hackalot.game.entity;

import com.badlogic.gdx.math.Vector2;

/**
 * Animal class, currently only parent to sheep.java
 * @author HANHAN
 *
 */
public class Animal extends Character {

	public Animal(Vector2 position, Vector2 velocity) {
		super(position, velocity);
	}
	
	public Animal(Vector2 position, Vector2 velocity, String name, int HP) {
		super(position, velocity, name, HP);
		// TODO Auto-generated constructor stub
	}

}
