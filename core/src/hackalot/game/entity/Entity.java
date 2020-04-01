package hackalot.game.entity;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import hackalot.game.SpriteActor;

import static hackalot.game.ref.Ref.R;

/**
 * Entity class is the part class of Character
 * 
 * @author HANHAN
 *
 */

public abstract class Entity {

	private Vector2 position;
	private Vector2 velocity; // (1,0) right (0,1) up (-1,0) left (0,-1) bottom

	private Actor actor;

	public Entity( Vector2 position ) {
		this.position = position; 
		this.velocity = new Vector2();
	}

	public Entity( Vector2 position, Actor actor ) {
		this.position = position;
		this.velocity = new Vector2();

		this.actor = actor;
		R.stage.addActor( this.actor );
	}

	public Entity( Vector2 position, Vector2 velocity ) {
		this.position = position;
		this.velocity = velocity;
	}

	public Entity( Vector2 position, Vector2 velocity, Actor actor ) {
		this.position = position;
		this.velocity = velocity;

		this.actor = actor;
		R.stage.addActor( this.actor );
	}

	public void setActor( Actor actor ) {
		if( this.actor != null ) {
			this.actor.remove();
		}

		this.actor = actor;
		this.actor.setPosition( position.x, position.y );
		this.actor.setSize( 48, 48 );
		R.stage.addActor( this.actor );
	}

	public Actor getActor() {
		return this.actor;
	}

	public abstract void tick();
	
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
