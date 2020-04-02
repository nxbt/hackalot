package hackalot.game.entity;

import hackalot.game.Updatable;
import hackalot.game.Updater;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Manages the creation, updating, and deletion of entities
 *
 * @author Brendan
 */
public class EntityManager implements Updater<Entity>, Updatable {
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

		// Updates all entities
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
}
