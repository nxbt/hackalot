package hackalot.game.crafting;

import java.util.ArrayList;
import java.util.List;

import hackalot.game.item.Item;
import hackalot.game.map.Building;
import hackalot.game.map.BuildingTile;
import hackalot.game.map.Map;
import hackalot.game.map.MapInfoProvider;
import hackalot.game.map.MapInfoQuerier;
import hackalot.game.map.MapUpdateReceiver;
import hackalot.game.map.MapUpdateSender;

/**
 * A Recipe describes how to build a craftable Structure.
 * @author ethan
 *
 */
public class Recipe implements MapUpdateSender, MapInfoQuerier {
	
	//TODO: allow rotation and flipping of recipes
	
	private Item item;
	
	private int[] xOffsets;
	private int[] yOffsets;
	private TileMatcher[] matchers;
	private TileUpdater[] updaters;
	
	private MapUpdateReceiver receiver;
	private MapInfoProvider provider;
	
	/**
	 * Constructs a new Recipe consisting of a set of tile matchers and updates.
	 * 
	 * Note: Recipies should probably be built with RecipeBuilder.
	 * 
	 * @param xOffsets Tells the Recipe which x coordinates are covered by this recipe.
	 * @param yOffsets Tells the Recipe which y coordinates are covered by this recipe.
	 * @param matchers Tells the Recipe what to look for on each tile covered by this recipe.
	 * @param updaters Tells the Recipe how to change the tiles when a structure is built.
	 * @param item Tells the Recipe what Item activates this Recipe.
	 */
	public Recipe(int[] xOffsets, int[] yOffsets, TileMatcher[] matchers, TileUpdater[] updaters, Item item) {
		this.xOffsets = xOffsets;
		this.yOffsets = yOffsets;
		this.matchers = matchers;
		this.updaters = updaters;
		this.item = item;
	}
	
	/**
	 * Checks if this Recipe can make a blueprint at location (x, y)
	 * @param x The x coordiante
	 * @param y The y coordiante
	 * @return True if this recipe can make a Blueprint at the location.
	 */
	public boolean matches(int x, int y) {
		for(int i = 0; i < matchers.length; i++) {
			matchers[i].setProvider(getMapInfoProvider());
			if(!matchers[i].matches(xOffsets[i] + x, yOffsets[i] + y)) return false;
		}
		
		return true;
	}
	
	/**
	 * Checks if the given tile overlaps this Recipe when the Recipe is centered at (centerX, centerY).
	 * @param centerX The x center to check.
	 * @param centerY The y center to check.
	 * @param x The x tile to check.
	 * @param y The y tile to check.
	 * @return True if (x, y) is in the recipe when centered at (centerX, centerY).
	 */
	public boolean overlaps(int centerX, int centerY, int x, int y) {
		for(int i = 0; i < matchers.length; i++) {
			if(xOffsets[i] + centerX == x && yOffsets[i] + centerY == y) return true;
		}
		return false;
	}
	
	/**
	 * Gets a Blueprint for this Recipe centered at (x, y)
	 * @param x The x center of the new Blueprint.
	 * @param y The y center of the new Blueprint.
	 * @return A new Blueprint.
	 */
	public Blueprint getBlueprint(int x, int y) {
		Blueprint blueprint = new Blueprint(this, x, y);
		blueprint.setProvider(getMapInfoProvider());
		blueprint.setReceiver(getMapUpdateReceiver());
		return blueprint;
	}
	
	/**
	 * Checks if the given item can activate this Recipe.
	 * @param item The item used to activate the Recipe.
	 * @return True if item can be used to activate this Recipe.
	 */
	public boolean canBuild(Item item) {
		return this.item.equals(item);
	}
	
	/**
	 * Gets all tiles that need to be checked for Blueprint updates for this Recipe when tile (x, y) is updated.
	 * @param x The x tile updated.
	 * @param y The y tile updated.
	 * @return A List of tiles that need to be checked for updates to this Recipe's Blueprints.
	 */
	public List<int[]> getAffectedTiles(int x, int y) {
		List<int[]> tiles = new ArrayList<int[]>();
		
		// TODO: might not work for non-square recipes, test later!
		for(int i = 0; i < matchers.length; i++) {
			tiles.add(new int[] {x - xOffsets[i], y - yOffsets[i]});
		}
		
		return tiles;
	}

	/**
	 * Builds this recipe at (x, y).
	 * @param x The x position to build the recipe.
	 * @param y The y position to build the recipe.
	 * @return A new Building, built by this Recipe at the given position.
	 */
	public Building build(int x, int y) {
		BuildingTile[] buildingTiles = new BuildingTile[matchers.length];
		for(int i = 0; i < matchers.length; i++) {
			int xOffset = xOffsets[i];
			int yOffset = yOffsets[i];
			
			System.out.println("Updating tile " + (x + xOffset) + " " + (y + yOffset));
			updaters[i].setReceiver(getMapUpdateReceiver());
			updaters[i].update(x + xOffset, y + yOffset);
			
			// TODO: doesn't support recipe pieces that require an item to be on a tile but don't place a building on that tile.
			buildingTiles[i] = getMapInfoProvider().getTile(x + xOffset, y + yOffset).getBuildingTile();
		}
		
		return new Building(buildingTiles);
	}
	
	/**
	 * Sets the MapInfoProvider that should respond to Queries from this Recipe.
	 * @param provider The new MapInfoProvider.
	 */
	@Override
	public void setProvider(MapInfoProvider provider) {
		this.provider = provider;
		
	}
	
	/**
	 * Gets the MapInfoProvider that is responding to Queries from this Recipe.
	 * @return The MapInfoProvider
	 */
	@Override
	public MapInfoProvider getMapInfoProvider() {
		return provider;
	}


	/**
	 * Sets the MapUpdateReceiver that should receive updates from this Recipe.
	 * @param receiver The new receiver.
	 */
	@Override
	public void setReceiver(MapUpdateReceiver receiver) {
		this.receiver = receiver;
		
	}
	
	/**
	 * Gets the MapUpdateReceiver that is Receiving updates from this Recipe.
	 * @return The MapUpdateReceiver.
	 */
	@Override
	public MapUpdateReceiver getMapUpdateReceiver() {
		return receiver;
	}
}
