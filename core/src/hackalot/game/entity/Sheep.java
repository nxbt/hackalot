package hackalot.game.entity;

import com.badlogic.gdx.math.Vector2;

/**
 * Represents the sheep- viva la sheepavolution
 * @author HANHAN
 *
 */
public class Sheep extends Animal {

	private boolean sheared; //is the sheep sheared?
	
	public Sheep( Vector2 position ) {
		super( position );
	}

	public Sheep(Vector2 position, Vector2 velocity, String name, int HP) {
		super(position, velocity, name, HP);
	}

	@Override
	public void tick() {

	}

	public boolean getSheared() {
		return sheared;
	}
	
	public void setSheared(Boolean sheared) {
		this.sheared = sheared;
	}
}
