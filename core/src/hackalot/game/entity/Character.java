package hackalot.game.entity;

import com.badlogic.gdx.math.Vector2;

/**
 * Parent class for Player, Enemy, and Animal. Has main functionality for our characters
 * @author HANHAN
 *
 */
public class Character extends Entity {
	
	private String name;
	private int HP; 
	private Item item;
	private Controller controller;
	
	
	//Super Constructor
	public Character(Vector2 position, Vector2 velocity) {
		super(position, velocity);
		// TODO Auto-generated constructor stub
	}
	
	public Character(Vector2 position, Vector2 velocity, String name, int HP) {
		super(position, velocity);
		this.name = name;
		this.HP = HP;
	}
	

	/**
	 * changes velocity to new unit vector direction
	 * @param velocity
	 */
	private void move(Vector2 velocity) {
		setPosition(getPosition().add(velocity));
	}
	
	/**
	 * Returns the tile 1 tile in the direction of the velocity.
	 * @return Tile 
	 */
	
	
	public Tile getTileAhead() {
		return new Tile();
	}
	
	
	public void setItem(Item item) {
		this.item = item; 
	}
	public Item getItem() {
		return item;
	}

}
