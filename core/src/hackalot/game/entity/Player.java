package hackalot.game.entity;

import com.badlogic.gdx.math.Vector2;

/**
 * Will represent the player
 * @author HANHAN
 *
 */
public class Player extends Character {

	public Player(Vector2 position, Vector2 velocity) {
		super(position, velocity);
		// TODO Auto-generated constructor stub
	}
	
	public Player(Vector2 position, Vector2 velocity, String name, int HP) {
		super(position, velocity, name, HP);
	}
	
	/**
	 * pickup item from tile infront of player 
	 * returns true if pick up successful
	 * returns false if pick up unsuccessful
	 * @param item
	 */
//	private boolean pickUp(Tile tile) {
//		if (!tile.isEmpty()) {
//			setItem(tile.getItem());
//			tile.setItem(null);
//			
//			return true;
//		}
//		
//		return false; //cannot pick up; tile empty;
//	}
	
	
	/**
	 * Drop item in hand onto ahead tile
	 * True if dropped, false if failed
	 * @return
	 */
//	private boolean drop() {
//		Item itemInHand = getItem();
//		Tile tileAhead = getTileAhead();
//		
//		if (tileAhead.isEmpty()) {
//			setItem(null);
//			tileAhead.setItem(itemInHand);
//			return true;
//		}
//		return false;
//		
//	}

	private void interact() {
		
	}
	
}