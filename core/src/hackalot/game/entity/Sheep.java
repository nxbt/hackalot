package hackalot.game.entity;

import com.badlogic.gdx.math.Vector2;

/**
 * Represents the sheep- viva la sheepavolution
 * @author HANHAN
 *
 */
public class Sheep extends Animal {

	private boolean sheared; //is the sheep sheared?
	
	public Sheep(Vector2 position, Vector2 velocity) {
		super(position, new Vector2(0,0));
		// TODO Auto-generated constructor stub
	}

	public Sheep(Vector2 position, Vector2 velocity, String name, int HP) {
		super(position, velocity, name, HP);
		// TODO Auto-generated constructor stub
	}
	
	public boolean getSheared() {
		return sheared;
	}
	
	public void setSheared(Boolean sheared) {
		this.sheared = sheared;
	}
}
