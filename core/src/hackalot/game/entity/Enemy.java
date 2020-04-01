package hackalot.game.entity;

import com.badlogic.gdx.math.Vector2;

import hackalot.game.map.*;

/**
 * Class that contains functionality for the enemies that attack
 * @author HANHAN
 *
 */
public abstract class Enemy extends Character {

	private int damage = 1; // hard coded damage parameter
	
	public Enemy( Vector2 position ) {
		super( position );
	}
	
	public Enemy(Vector2 position, Vector2 velocity, String name, int HP) {
		super(position, velocity, name, HP);
	}

	/**
	 * Takes in tile infront of enemy and attacks only if tile has building
	 */
	private void attack(Tile tileAhead) {
		if (tileAhead.hasBuildingTile()) {
			BuildingTile buildingTile = tileAhead.getBuildingTile();
			buildingTile.setHealth(buildingTile.getHealth() - damage);
		}
	}
}
