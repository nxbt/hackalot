package hackalot.game.crafting;

import java.util.ArrayList;
import java.util.List;

import hackalot.game.item.Item;
import hackalot.game.map.Map;
import hackalot.game.map.MapInfoProvider;
import hackalot.game.map.MapInfoQuerier;
import hackalot.game.map.MapUpdateReceiver;
import hackalot.game.map.MapUpdateSender;

public class RecipeManager implements MapUpdateSender, MapInfoQuerier {
	private List<Recipe> recipes;
	private List<Blueprint> blueprints;
	
	private MapUpdateReceiver receiver;
	private MapInfoProvider provider;
	
	public RecipeManager() {
		recipes = new ArrayList<Recipe>();
		blueprints = new ArrayList<Blueprint>();
	}
	
	public void addRecipe(Recipe recipe) {
		this.recipes.add(recipe);
		recipe.setReceiver(getMapUpdateReceiver());
		recipe.setProvider(getMapInfoProvider());
	}
	
	public void updateBlueprints(Map map, int x, int y) {
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
	
	public Blueprint getBuildableBlueprint(Map map, int x, int y, Item item) {
		for(Blueprint blueprint: blueprints) {
			if(blueprint.overlaps(x, y) && blueprint.canBuild(item)) return blueprint;
		}
		return null;
	}

	@Override
	public void setProvider(MapInfoProvider provider) {
		this.provider = provider;
		
	}

	@Override
	public MapInfoProvider getMapInfoProvider() {
		return provider;
	}

	@Override
	public void setReceiver(MapUpdateReceiver receiver) {
		this.receiver = receiver;
		
	}

	@Override
	public MapUpdateReceiver getMapUpdateReceiver() {
		return receiver;
	}
	
}
