package hackalot.game.crafting;

import hackalot.game.item.Item;

/**
 * A recipeInfoProvider responds to Queries from a RecipeInfoQuerier.
 * @author ethan
 *
 */
public interface RecipeInfoProvider {
	
	/**
	 * Gets a Blueprint that can be built at location (x, y) with item.
	 * @param x The x coordinate.
	 * @param y The y coordinate.
	 * @param item The item used to activate the Blueprint.
	 * @return An activatable Blueprint, or null if no such blueprint exists.
	 */
	abstract public Blueprint getBuildableBlueprint(int x, int y, Item item);
}
