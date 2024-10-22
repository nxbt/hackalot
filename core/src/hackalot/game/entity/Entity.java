package hackalot.game.entity;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

import hackalot.game.Updatable;
import hackalot.game.map.MapInfoProvider;
import hackalot.game.map.MapInfoQuerier;
import hackalot.game.map.MapUpdateReceiver;
import hackalot.game.map.MapUpdateSender;


/**
 * Entity class is the part class of Character
 * 
 * @author HANHAN
 *
 */
public abstract class Entity implements EntityUpdateSender, EntityInfoQuerier, MapInfoQuerier, MapUpdateSender, Updatable {

	private Vector2 position;
	private Vector2 velocity; // (1,0) right (0,1) up (-1,0) left (0,-1) bottom

	private Actor actor;
	
	private MapInfoProvider mapInfoProvider;
	
	private MapUpdateReceiver mapUpdateReceiver;
	
	private EntityUpdateReceiver entityUpdateReceiver;
	private EntityInfoProvider provider;

	public Entity( Vector2 position ) {
		this.position = position; 
		this.velocity = new Vector2();
	}

	public Entity( Vector2 position, Actor actor ) {
		this.position = position;
		this.velocity = new Vector2();

		this.actor = actor;
//		R.stage.addActor( this.actor );
	}

	public Entity( Vector2 position, Vector2 velocity ) {
		this.position = position;
		this.velocity = velocity;
	}

	public Entity( Vector2 position, Vector2 velocity, Actor actor ) {
		this.position = position;
		this.velocity = velocity;

		this.actor = actor;
//		R.stage.addActor( this.actor );
	}

	public void setActor( Actor actor ) {
		if( this.actor != null ) {
			this.actor.remove();
		}

		this.actor = actor;
		this.actor.setPosition( position.x, position.y );
		this.actor.setSize( 48, 48 );
//		R.stage.addActor( this.actor );
	}

	public Actor getActor() {
		return this.actor;
	}
	
	public Vector2 getPosition() {
		return position;
	}
	public void setPosition(Vector2 position) {
		this.position = position;
		actor.setPosition(position.x, position.y);
	}
	
	public void accelerate(Vector2 acceleration) {
		velocity.add(acceleration).limit(1); 
	}
	
	public Vector2 getVelocity() {
		return velocity;
	}

	/**
	 * Getters and setters for the receiver
	 */
	@Override
	public EntityUpdateReceiver getEntityUpdateReceiver(){ return this.entityUpdateReceiver; }
	@Override
	public void setReceiver( EntityUpdateReceiver entity){ this.entityUpdateReceiver = entity; }

	/**
	 * Getters and setters for the InfoProvider
	 */
	@Override
	public EntityInfoProvider getEntityInfoProvider(){ return this.provider; }
	@Override
	public void setProvider(EntityInfoProvider provider){ this.provider = provider; }
	
	/**
	 * Sets the MapInfoProvider that should respond to Queries from this MapInfoQuerier.
	 * @param provider The new MapInfoProvider.
	 */
	public void setProvider(MapInfoProvider provider) {
		this.mapInfoProvider = provider;
	};
	
	/**
	 * Gets the MapInfoProvider that is responding to Queries from this MapInfoQuerier.
	 * @return The MapInfoProvider
	 */
	public MapInfoProvider getMapInfoProvider() {
		return mapInfoProvider;
	};


	/**
	 * Sets the MapUpdateReceiver that should receive updates from this MapUpdateSender.
	 * @param receiver The new receiver.
	 */
	public void setReceiver(MapUpdateReceiver receiver) {
		this.mapUpdateReceiver = receiver;
	}
	
	/**
	 * Gets the MapUpdateReceiver that is Receiving updates from this MapUpdateSender.
	 * @return The MapUpdateReceiver.
	 */
	public MapUpdateReceiver getMapUpdateReceiver() {
		return mapUpdateReceiver;
	}
}
