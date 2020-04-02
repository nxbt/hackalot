package hackalot.game.crafting;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;

import hackalot.game.item.Item;
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
				System.out.println("Blueprint Destroyed!");
			}
		}
		
		// second, check for new blueprints from recipes
		
		for(Recipe recipe: recipes) {
			System.out.println("Checking Recipe");
			for(int[] coords: recipe.getAffectedTiles(x, y)) {
				System.out.println("Tile Affected: " + coords[0] + ", " + coords[1]);
				if(recipe.matches(map, coords[0], coords[1])) {
					System.out.println("Recipe Matches");
					blueprints.add(recipe.getBlueprint(coords[0], coords[1]));
					System.out.println("Blueprint Created!");
				}
			}
		}
		
	}
	
	public Blueprint getBuildableBlueprint(Map map, int x, int y, Item item) {
		for(Blueprint blueprint: blueprints) {
			if(blueprint.overlaps(x, y) && blueprint.canBuild(item)) return blueprint;
		}
		return null;
	}
	
}
