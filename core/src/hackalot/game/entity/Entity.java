package hackalot.game.entity;

import com.badlogic.gdx.math.Vector2;


/**
 * Entity class is the part class of Character
 * 
 * @author HANHAN
 *
 */

public abstract class Entity {
	private Vector2 position;
	private Vector2 velocity; // (1,0) right (0,1) up (-1,0) left (0,-1) bottom
	
	public Entity(Vector2 position, Vector2 velocity) {
		
		this.position = position; 
		this.velocity = new Vector2(0,0);		
	}
	
	
	private void update() {
		
	}
	
	private void draw() {
		
	}
	
	public Vector2 getPosition() {
		return position;
	}
	public void setPosition(Vector2 position) {
		this.position = position;
	}
	
	public void accelerate(Vector2 acceleration) {
		velocity.add(acceleration).limit(1); 
	}
	
}
