package hackalot.game.map;

import hackalot.game.crafting.Recipe;
import hackalot.game.item.Item;

// blueprint for a building, shows as light blue outline on screen
public class Blueprint {
	private int x;
	private int y;
	private Building building;
	private Recipe recipe;
	
	public boolean canBuild(Item item) {
		return recipe.canBuild(item);
	}
	
	public boolean overlaps(int x, int y) {
		return recipe.overlaps(this.x, this.y, x, y);
	}
	
	public boolean isValid(Map map) {
		return recipe.matches(map, x, y);
	}
}
