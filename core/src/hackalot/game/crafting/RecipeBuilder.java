package hackalot.game.crafting;

import java.util.ArrayList;
import java.util.List;

import hackalot.game.item.Item;
import hackalot.game.item.Resource;
import hackalot.game.map.BuildingTile;

public class RecipeBuilder {
	
	private Item item;
	
	private List<Integer> xOffsets;
	private List<Integer> yOffsets;
	private List<TileMatcher> matchers;
	private List<TileUpdater> updaters;
	
	public RecipeBuilder(Item item) {
		this.item = item;
		xOffsets = new ArrayList<Integer>();
		yOffsets = new ArrayList<Integer>();
		matchers = new ArrayList<TileMatcher>();
		updaters = new ArrayList<TileUpdater>();
	};
	
	public void addInfo(int xOffset, int yOffset, TileMatcher matcher, TileUpdater updater) {
		xOffsets.add(xOffset);
		yOffsets.add(yOffset);
		matchers.add(matcher);
		updaters.add(updater);
	}
	
	public Recipe getRecipe() {
		int[] xOffsets = new int[this.xOffsets.size()];
		int[] yOffsets = new int[this.yOffsets.size()];
		TileMatcher[] matchers = new TileMatcher[this.matchers.size()];
		TileUpdater[] updaters = new TileUpdater[this.updaters.size()];
		
		for(int i = 0; i < matchers.length; i++) {
			xOffsets[i] = this.xOffsets.get(i);
			yOffsets[i] = this.yOffsets.get(i);
			matchers[i] = this.matchers.get(i);
			updaters[i] = this.updaters.get(i);
		}
		
		return new Recipe(xOffsets, yOffsets, matchers, updaters, item);
	}
	
	public static Recipe getBarnRecipe() {
		Item wood = new Resource("wood.png", "wood", 1, null, null);
		RecipeBuilder builder = new RecipeBuilder(wood);
		
		TileMatcher woodMatcher = new TileMatcher(null, wood, null);
		TileUpdater barnUpdater = new TileUpdater("grass", null, new BuildingTile("barnWall"));
		
		builder.addInfo(0, 0, woodMatcher, barnUpdater);
		builder.addInfo(0, 1, woodMatcher, barnUpdater);
		builder.addInfo(0, 2, woodMatcher, barnUpdater);
		
		builder.addInfo(1, 0, woodMatcher, barnUpdater);
		builder.addInfo(1, 1, woodMatcher, barnUpdater);
		builder.addInfo(1, 2, woodMatcher, barnUpdater);
		
		builder.addInfo(2, 0, woodMatcher, barnUpdater);
		builder.addInfo(2, 1, woodMatcher, barnUpdater);
		builder.addInfo(2, 2, woodMatcher, barnUpdater);
		
		return builder.getRecipe();
		
	}
}
