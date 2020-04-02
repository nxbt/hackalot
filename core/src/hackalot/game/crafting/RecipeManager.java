package hackalot.game.crafting;

import java.util.ArrayList;
import java.util.List;

import hackalot.game.item.Item;
import hackalot.game.map.Map;
import hackalot.game.map.MapInfoProvider;
import hackalot.game.map.MapInfoQuerier;
import hackalot.game.map.MapUpdateReceiver;
import hackalot.game.map.MapUpdateSender;

/**
 * The RecipeManager manages a set of Recipes and Blueprints.
 * @author ethan
 *
 */
public class RecipeManager implements MapUpdateSender, MapInfoQuerier, RecipeUpdateReceiver, RecipeInfoProvider {
	private List<Recipe> recipes;
	private List<Blueprint> blueprints;
	
	private MapUpdateReceiver receiver;
	private MapInfoProvider provider;
	
	public RecipeManager() {
		recipes = new ArrayList<Recipe>();
		blueprints = new ArrayList<Blueprint>();
	}

	/**
	 * Tells the RecipeManager to add a new Recipe.
	 * @param recipe The new Recipe.
	 */
	@Override
	public void addRecipe(Recipe recipe) {
		this.recipes.add(recipe);
		recipe.setReceiver(getMapUpdateReceiver());
		recipe.setProvider(getMapInfoProvider());
	}


	/**
	 * Tells the RecipeManager that the tile at (x, y) has been updated, and 
	 * updates all affected Blueprints.
	 * @param x The x position.
	 * @param y The y position.
	 */
	public void updateBlueprints(int x, int y) {
		// first, check if any blueprints are invalidated by the change.
		for(int i = 0; i < blueprints.size(); i++) {
			Blueprint blueprint = blueprints.get(i);
			if(!blueprint.isValid()) {
				blueprints.remove(i);
				i--;
				System.out.println("Blueprint Destroyed!");
			}
		}
		
		// second, check for new blueprints from recipes
		
		for(Recipe recipe: recipes) {
			System.out.println("Checking Recipe");
			for(int[] coords: recipe.getAffectedTiles(x, y)) {
				System.out.println("Tile Affected: " + coords[0] + ", " + coords[1]);
				if(recipe.matches(coords[0], coords[1])) {
					System.out.println("Recipe Matches");
					blueprints.add(recipe.getBlueprint(coords[0], coords[1]));
					System.out.println("Blueprint Created!");
				}
			}
		}
		
	}

	/**
	 * Gets a Blueprint that can be built at location (x, y) with item.
	 * @param x The x coordinate.
	 * @param y The y coordinate.
	 * @param item The item used to activate the Blueprint.
	 * @return An activatable Blueprint, or null if no such blueprint exists.
	 */
	public Blueprint getBuildableBlueprint(int x, int y, Item item) {
		for(Blueprint blueprint: blueprints) {
			if(blueprint.overlaps(x, y) && blueprint.canBuild(item)) return blueprint;
		}
		return null;
	}

	/**
	 * Sets the MapInfoProvider that should respond to Queries from this RecipeManager.
	 * @param provider The new MapInfoProvider.
	 */
	@Override
	public void setProvider(MapInfoProvider provider) {
		this.provider = provider;
		
	}

	/**
	 * Gets the MapInfoProvider that is responding to Queries from this RecipeManager.
	 * @return The MapInfoProvider
	 */
	@Override
	public MapInfoProvider getMapInfoProvider() {
		return provider;
	}

	/**
	 * Sets the MapUpdateReceiver that should receive updates from this RecipeManager.
	 * @param receiver The new receiver.
	 */
	@Override
	public void setReceiver(MapUpdateReceiver receiver) {
		this.receiver = receiver;
		
	}
	
	/**
	 * Gets the MapUpdateReceiver that is Receiving updates from this RecipeManager.
	 * @return The MapUpdateReceiver.
	 */
	@Override
	public MapUpdateReceiver getMapUpdateReceiver() {
		return receiver;
	}
	
}
