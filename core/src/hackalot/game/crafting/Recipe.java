package hackalot.game.crafting;

import hackalot.game.map.Blueprint;
import hackalot.game.map.Map;

public class Recipe {
	
	private Item item;
	
	private int[] xOffsets;
	private int[] yOffsets;
	private TileMatcher[] matchers;
	
	public boolean matches(Map map, int x, int y) {
		for(int i = 0; i < matchers.length; i++) {
			if(!matchers[i].matches(map.getTile(xOffsets[i] + x, yOffsets[i] + y))) return false;
		}
		
		return true;
	}
	
	public boolean overlaps(int centerX, int centerY, int x, int y) {
		for(int i = 0; i < matchers.length; i++) {
			if(xOffsets[i] + centerX == x && yOffsets[i] + centerY == y) return true;
		}
		return false;
	}
	
	public Blueprint getBlueprint() {
		return null;
	}
	
	public Blueprint canBuild(Item item) {
		return this.item.equals(item);
	}
}
