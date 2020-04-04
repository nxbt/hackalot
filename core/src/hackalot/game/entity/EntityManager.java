package hackalot.game.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import hackalot.game.Updatable;
import hackalot.game.Updater;
import hackalot.game.map.MapInfoProvider;
import hackalot.game.map.MapInfoQuerier;
import hackalot.game.stage.StageUpdateReceiver;
import hackalot.game.stage.StageUpdateSender;

/**
 * Manages the creation, updating, and deletion of entities
 *
 * @author Brendan
 */
public class EntityManager implements Updater<Entity>, Updatable, EntityInfoProvider, EntityUpdateReceiver, StageUpdateSender, MapInfoQuerier {

	private StageUpdateReceiver stageUpdateReceiver;
	private MapInfoProvider mapInfoProvider;
	private List<Entity> entities;

	/**
	 * Default constructor
	 */
	public EntityManager() {
		entities = new ArrayList<Entity>();
	}

	/**
	 * Updates all of the entities this object manages
	 */
	@Override
	public void update() {
		Iterator<Entity> itr = getUpdatables();

		while( itr.hasNext() ) {
			itr.next().update();
		}
	}

	/**
	 * Adds an entity to this entity manager
	 * @param entity The entity we wish to add
	 */
	@Override
	public void addUpdatable( Entity entity ) {
		entities.add( entity );
	}

	/**
	 * Removes an entity from this entity manager
	 * @param entity The entity to remove
	 * @return True if the entity was successfully removed
	 */
	@Override
	public boolean removeUpdatable( Entity entity ) {
		return entities.remove( entity );
	}

	/**
	 * Gets an iterator over the entities
	 * @return An entity iterator
	 */
	@Override
	public Iterator<Entity> getUpdatables() {
		return entities.iterator();
	}

	/**
	 * Gets a list of entities for an EntityInfoQuerier
	 * @return The list of entities this provider has
	 */
	@Override
	public List<Entity> getEntities() {
		return entities;
	}

	/**
	 * Adds an entity to this manager and ensures its actor is added to the stage
	 * @param entity The entity to add to the game world
	 */
	@Override
	public void spawn( Entity entity ) {
		addUpdatable( entity );

		getStageUpdateReceiver().addActor( entity.getActor() );
		entity.setProvider(mapInfoProvider);
	}

	/**
	 * Removes an entity from this manager and from the stage. Does nothing if the entity is not in this manager
	 * @param entity The entity to remove
	 */
	@Override
	public void despawn( Entity entity ) {
		if( removeUpdatable( entity ) ) {
			getStageUpdateReceiver().removeActor( entity.getActor() );
			entity.setProvider((MapInfoProvider) null);
		}
	}

	/**
	 * Sets the StageUpdateReceiver for this object
	 * @param receiver The StageUpdateReceiver to use
	 */
	@Override
	public void setReceiver( StageUpdateReceiver receiver ) {
		this.stageUpdateReceiver = receiver;
	}

	/**
	 * Gets the StageUpdateReceiver this object is using
	 * @return The stageUpdateReceiver being used
	 */
	@Override
	public StageUpdateReceiver getStageUpdateReceiver() {
		return this.stageUpdateReceiver;
	}

	@Override
	public void setProvider(MapInfoProvider provider) {
		this.mapInfoProvider = provider;
		
	}

	@Override
	public MapInfoProvider getMapInfoProvider() {
		return this.mapInfoProvider;
	}
}
