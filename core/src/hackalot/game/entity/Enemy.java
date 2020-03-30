package hackalot.game.entity;

import com.badlogic.gdx.math.Vector2;

/**
 * Class that contains functionality for the enemies that attack
 * @author HANHAN
 *
 */
public class Enemy extends Character {

	private int damage = 1; // hard coded damage parameter
	
	public Enemy(Vector2 position, Vector2 velocity) {
		super(position, velocity);
		// TODO Auto-generated constructor stub
	}
	
	public Enemy(Vector2 position, Vector2 velocity, String name, int HP) {
		super(position, velocity, name, HP);
	}

	
	/**
	 * Takes in tile infront of enemy and attacks only if tile has building
	 */
	private void attack(Tile tileAhead) {
		
		if (tileAhead.hasBuilding) {
			tileAhead.getBuilding().setHealth -= damage;
		}
		
	}
}
