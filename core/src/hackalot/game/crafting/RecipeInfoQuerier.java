package hackalot.game.crafting;

/**
 * A RecipeInfoQuerier sends queries to a RecipeInfoProvider.
 * @author ethan
 *
 */
public interface RecipeInfoQuerier {
	
	/**
	 * Sets the RecipeInfoProvider that this RecipeInfoQuerier should send Queries to.
	 * @param provider The new RecipeInfoProvider.
	 */
	abstract public void setProvider(RecipeInfoProvider provider);
	
	/**
	 * Gets the RecipeInfoProvider that this RecipeInfoQuerier is sending Queries to.
	 * @return The RecipeInfoProvider that is being send Queries.
	 */
	abstract public RecipeInfoProvider getRecipeInfoProvider();

}
