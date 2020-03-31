package hackalot.game.crafting;

import com.badlogic.gdx.scenes.scene2d.Actor;

import hackalot.game.item.Item;
import hackalot.game.map.Building;
import hackalot.game.map.Map;

// blueprint for a building, shows as light blue outline on screen
public class Blueprint {
	private int x;
	private int y;
	private Recipe recipe;
	
	// may be used later to draw the light blue overlay on screen;
	private Actor actor;
	
	public Blueprint(Recipe recipe, int x, int y) {
		this.recipe = recipe;
		this.x = x;
		this.y = y;
	}
	
	public boolean canBuild(Item item) {
		return recipe.canBuild(item);
	}
	
	public boolean overlaps(int x, int y) {
		return recipe.overlaps(this.x, this.y, x, y);
	}
	
	public boolean isValid(Map map) {
		return recipe.matches(map, x, y);
	}
	
	public Building build(Map map) {
		return recipe.build(map, x, y);
	}
	
	public Actor getActor() {
		return actor;
	}
}
