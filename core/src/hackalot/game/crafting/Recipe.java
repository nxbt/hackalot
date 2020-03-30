package hackalot.game.crafting;

import com.badlogic.gdx.math.Vector2;

import hackalot.game.map.Map;

public class Recipe {
	
	private Item item;
	
	private int[] xOffsets;
	private int[] yOffsets;
	private TileMatcher[] matchers;
	
	private boolean matches(Map map, int x, int y, Item item) {
		if(!this.item.equals(item)) return false;
		for(int i = 0; i < matchers.length; i++) {
			if(!matchers[i].matches(map.getTile(xOffsets[i] + x, yOffsets[i] + y))) return false;
		}
		
		return true;
		
	}
}
