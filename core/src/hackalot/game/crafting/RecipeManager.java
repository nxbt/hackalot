package hackalot.game.crafting;

import java.util.List;

import hackalot.game.map.Map;

public class RecipeManager {
	private List<Recipe> recipes;
	
	public Recipe getCraftableRecipe(Map map, int x, int y, Item item) {
		for(Recipe recipe: recipes) {
			if(recipe.matches(map, x, y, item)) return recipe;
		}
		
		return null;
	}
	
}
