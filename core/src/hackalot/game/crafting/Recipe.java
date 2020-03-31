package hackalot.game.crafting;

import java.util.ArrayList;
import java.util.List;

import hackalot.game.item.Item;
import hackalot.game.map.Building;
import hackalot.game.map.BuildingTile;
import hackalot.game.map.Map;

public class Recipe {
	
	private Item item;
	
	private int[] xOffsets;
	private int[] yOffsets;
	private TileMatcher[] matchers;
	private TileUpdater[] updaters;
	
	public Recipe(int[] xOffsets, int[] yOffsets, TileMatcher[] matchers, TileUpdater[] updaters, Item item) {
		this.xOffsets = xOffsets;
		this.yOffsets = yOffsets;
		this.matchers = matchers;
		this.updaters = updaters;
		this.item = item;
	}
	
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
	
	public Blueprint getBlueprint(int x, int y) {
		return new Blueprint(this, x, y);
	}
	
	public boolean canBuild(Item item) {
		return this.item.equals(item);
	}
	
	public List<int[]> getAffectedTiles(int x, int y) {
		List<int[]> tiles = new ArrayList<int[]>();
		
		// TODO: might not work for non-square recipes, test later!
		for(int i = 0; i < matchers.length; i++) {
			tiles.add(new int[] {x - xOffsets[i], y - yOffsets[i]});
		}
		
		return tiles;
	}

	public Building build(Map map, int x, int y) {
		BuildingTile[] buildingTiles = new BuildingTile[matchers.length];
		for(int i = 0; i < matchers.length; i++) {
			int xOffset = xOffsets[i];
			int yOffset = yOffsets[i];
			
			System.out.println("Updating tile " + (x + xOffset) + " " + (y + yOffset));
			updaters[i].update(map.getTile(x + xOffset, y + yOffset));
			map.updateTile(x + xOffset, y + yOffset);
			
			// TODO: doesn't support recipe pieces that require an item to be on a tile but don't place a building on that tile.
			buildingTiles[i] = map.getTile(x + xOffset, y + yOffset).getBuildingTile();
		}
		
		return new Building(buildingTiles);
	}
}
