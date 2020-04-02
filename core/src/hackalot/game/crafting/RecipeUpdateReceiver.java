package hackalot.game.crafting;

/**
 * A recipeUpdateReceiver responds to updates from a RecipeUpdateSender.
 * @author ethan
 *
 */
public interface RecipeUpdateReceiver {

	/**
	 * Tells the RecipeUpdateReceiver that the tile at (x, y) has been updated, and 
	 * updates all affected Blueprints.
	 * @param x The x position.
	 * @param y The y position.
	 */
	abstract public void updateBlueprints(int x, int y);
	
	/**
	 * Tells the RecipeUpdateReceiver to add a new Recipe.
	 * @param recipe The new Recipe.
	 */
	abstract public void addRecipe(Recipe recipe);
	
}
