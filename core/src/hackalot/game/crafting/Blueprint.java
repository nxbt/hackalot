package hackalot.game.crafting;

import com.badlogic.gdx.scenes.scene2d.Actor;

import hackalot.game.item.Item;
import hackalot.game.map.Building;
import hackalot.game.map.Map;
import hackalot.game.map.MapInfoProvider;
import hackalot.game.map.MapInfoQuerier;
import hackalot.game.map.MapUpdateReceiver;
import hackalot.game.map.MapUpdateSender;

// blueprint for a building, shows as light blue outline on screen
public class Blueprint implements MapUpdateSender, MapInfoQuerier {
	private int x;
	private int y;
	private Recipe recipe;
	
	// may be used later to draw the light blue overlay on screen;
	private Actor actor;
	
	private MapUpdateReceiver receiver;
	private MapInfoProvider provider;
	
	/**
	 * Constructs a new Blueprint.
	 * @param recipe This Blueprint's Recipe.
	 * @param x The x coordinate of this Blueprint.
	 * @param y The y coordinate of this Blueprint.
	 */
	public Blueprint(Recipe recipe, int x, int y) {
		this.recipe = recipe;
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Checks if this Blueprint can be built by item.
	 * @param item The item used to activate this Blueprint.
	 * @return True if item can activate this Blueprint.
	 */
	public boolean canBuild(Item item) {
		return recipe.canBuild(item);
	}
	
	/**
	 * Checks if the tile at (x, y) is in this Blueprint.
	 * @param x The x position of the tile.
	 * @param y The y position of the tile.
	 * @return True if the tile is inside this Blueprint.
	 */
	public boolean overlaps(int x, int y) {
		return recipe.overlaps(this.x, this.y, x, y);
	}
	
	/**
	 * Checks if this Blueprint's Recipe is still valid.
	 * @return True if this Blueprint is still valid.
	 */
	public boolean isValid() {
		recipe.setProvider(getMapInfoProvider());
		recipe.setReceiver(getMapUpdateReceiver());
		return recipe.matches(x, y);
	}
	
	/**
	 * Builds this Blueprint.
	 * @return A new Building built from this Blueprint.
	 */
	public Building build() {
		recipe.setProvider(getMapInfoProvider());
		recipe.setReceiver(getMapUpdateReceiver());
		return recipe.build(x, y);
	}
	
	/**
	 * Gets the Actor for this Blueprint.
	 * @return The Actor for this Blueprint. 
	 */
	public Actor getActor() {
		return actor;
	}
	
	/**
	 * Sets the MapInfoProvider that should respond to Queries from this Blueprint.
	 * @param provider The new MapInfoProvider.
	 */
	@Override
	public void setProvider(MapInfoProvider provider) {
		this.provider = provider;
		
	}
	
	/**
	 * Gets the MapInfoProvider that is responding to Queries from this Blueprint.
	 * @return The MapInfoProvider
	 */
	@Override
	public MapInfoProvider getMapInfoProvider() {
		return provider;
	}


	/**
	 * Sets the MapUpdateReceiver that should receive updates from this Blueprint.
	 * @param receiver The new receiver.
	 */
	@Override
	public void setReceiver(MapUpdateReceiver receiver) {
		this.receiver = receiver;
	}
	
	/**
	 * Gets the MapInfoProvider that is responding to Queries from this Blueprint.
	 * @return The MapInfoProvider
	 */
	@Override
	public MapUpdateReceiver getMapUpdateReceiver() {
		return receiver;
	}
}
