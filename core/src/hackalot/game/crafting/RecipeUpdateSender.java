package hackalot.game.crafting;

/**
 * A RecipeUpdateSender sends updates to a RecipeUpdateReceiver.
 * @author ethan
 *
 */
public interface RecipeUpdateSender {
	
	/**
	 * Sets the RecipeUpdateReceiver that this RecipeUpdateSender should send updates to.
	 * @param receiver The new RecipeUpdateReceiver.
	 */
	abstract public void setReceiver(RecipeUpdateReceiver receiver);
	
	/**
	 * Gets the RecipeUpdateReceiver that this RecipeUpdateSender is sending updates to.
	 * @return The RecipeUpdateReceiver that is being sent updates.
	 */
	abstract public RecipeUpdateReceiver getRecipeUpdateReceiver();

}
