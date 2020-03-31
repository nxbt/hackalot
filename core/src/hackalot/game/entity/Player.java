package hackalot.game.entity;

import com.badlogic.gdx.math.Vector2;
import hackalot.game.item.Item;
import hackalot.game.map.Tile;

/**
 * Will represent the player
 * @author HANHAN
 *
 */
public class Player extends Character {

	public Player(Vector2 position, Vector2 velocity) {
		super(position, new Vector2(0,0));
		// TODO Auto-generated constructor stub
	}
	
	public Player(Vector2 position, Vector2 velocity, String name, int HP) {
		super(position, velocity, name, HP);
	}
	
	private void interact() {
		
	}
	
}
