package hackalot.game.crafting;

import java.util.ArrayList;
import java.util.List;

import hackalot.game.map.Blueprint;
import hackalot.game.map.Map;

public class RecipeManager {
	private List<Recipe> recipes;
	private List<Blueprint> blueprints;
	
	public RecipeManager() {
		recipes = new ArrayList<Recipe>();
		blueprints = new ArrayList<Blueprint>();
	}
	
	public void addRecipe(Recipe recipe) {
		this.recipes.add(recipe);
	}
	
	public void updateBlueprints(Map map, int x, int y) {
		// first, check if any blueprints are invalidated by the change.
		for(int i = 0; i < blueprints.size(); i++) {
			Blueprint blueprint = blueprints.get(i);
			if(!blueprint.isValid(map)) {
				blueprints.remove(i);
				i--;
			}
		}
		
		// second, check for new blueprints from recipes
		for(Recipe recipe: recipes) {
			if(recipe.matches(map, x, y)) blueprints.add(recipe.getBlueprint());
		}
		
	}
	
	public Blueprint getBuildableBlueprint(Map map, int x, int y, Item item) {
		for(Blueprint blueprint: blueprints) {
			if(blueprint.overlaps(x, y) && blueprint.canBuild(item)) return blueprint;
		}
		return null;
	}
	
}
