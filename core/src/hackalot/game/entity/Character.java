package hackalot.game.entity;

import com.badlogic.gdx.math.Vector2;

import hackalot.game.controller.Controller;
import hackalot.game.item.Item;
import hackalot.game.map.Tile;

/**
 * Parent class for Player, Enemy, and Animal. Has main functionality for our characters
 * @author HANHAN
 *
 */
public abstract class Character extends Entity {

	protected Controller controller;

	private String name;
	private int maxHealth;
	private int health;
	private Item item;

	public Character( Vector2 position ) {
		super(position);
	}
	
	public Character(Vector2 position, Vector2 velocity, String name, int health) {
		super( position, velocity );

		this.name = name;
		setMaxHealth( health );
	}

	public void setMaxHealth( int maxHealth ) {
		this.maxHealth = maxHealth;
		this.health = maxHealth;
	}

	public void setName( String name ) {
		this.name = name;
	}

	/**
	 * pickup item from tile in front of player
	 * returns true if pick up successful
	 * returns false if pick up unsuccessful
	 * @param tile
	 */
	private boolean pickUp(Tile tile) {
		if (!tile.hasItem()) {
			setItem(tile.getItem());
			tile.setItem(null);
			
			return true;
		}
		
		return false; //cannot pick up; tile empty;
	}
	
	
	/**
	 * This function will be used to receive an item from a non-tile source
	 * such as tools 
	 * @param item
	 * @return
	 */
	private boolean recieveItem(Item item){
		if(getItem() == null){
			setItem(item);
			return true;
		}
		return false;
	}
	
	
	/**
	 * Drop item in hand onto ahead tile
	 * True if dropped, false if failed
	 * @return
	 */
	private boolean drop() {
		Item itemInHand = getItem();
		Tile tileAhead = getTileAhead();
		
		if (!tileAhead.hasItem()) {
			setItem(null);
			tileAhead.setItem(itemInHand);
			return true;
		}
		return false;
		
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
		
		return null; 
	}

	
	
	public void setItem(Item item) {
		this.item = item;
	}
	public Item getItem() {
		return item;
	}

}
