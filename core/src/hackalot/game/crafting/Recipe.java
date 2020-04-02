package hackalot.game.crafting;

import java.util.ArrayList;
import java.util.List;

import hackalot.game.item.Item;
import hackalot.game.map.Building;
import hackalot.game.map.BuildingTile;
import hackalot.game.map.Map;
import hackalot.game.map.MapInfoProvider;
import hackalot.game.map.MapInfoQuerier;
import hackalot.game.map.MapUpdateReceiver;
import hackalot.game.map.MapUpdateSender;

public class Recipe implements MapUpdateSender, MapInfoQuerier {
	
	//TODO: allow rotation and flipping of recipes
	
	private Item item;
	
	private int[] xOffsets;
	private int[] yOffsets;
	private TileMatcher[] matchers;
	private TileUpdater[] updaters;
	
	private MapUpdateReceiver receiver;
	private MapInfoProvider provider;
	
	public Recipe(int[] xOffsets, int[] yOffsets, TileMatcher[] matchers, TileUpdater[] updaters, Item item) {
		this.xOffsets = xOffsets;
		this.yOffsets = yOffsets;
		this.matchers = matchers;
		this.updaters = updaters;
		this.item = item;
	}
	
	public boolean matches(int x, int y) {
		for(int i = 0; i < matchers.length; i++) {
			if(!matchers[i].matches(getMapInfoProvider().getTile(xOffsets[i] + x, yOffsets[i] + y))) return false;
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
		Blueprint blueprint = new Blueprint(this, x, y);
		blueprint.setProvider(getMapInfoProvider());
		blueprint.setReceiver(getMapUpdateReceiver());
		return blueprint;
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

	public Building build(int x, int y) {
		BuildingTile[] buildingTiles = new BuildingTile[matchers.length];
		for(int i = 0; i < matchers.length; i++) {
			int xOffset = xOffsets[i];
			int yOffset = yOffsets[i];
			
			System.out.println("Updating tile " + (x + xOffset) + " " + (y + yOffset));
			updaters[i].setReceiver(getMapUpdateReceiver());
			updaters[i].update(x + xOffset, y + yOffset);
			
			// TODO: doesn't support recipe pieces that require an item to be on a tile but don't place a building on that tile.
			buildingTiles[i] = getMapInfoProvider().getTile(x + xOffset, y + yOffset).getBuildingTile();
		}
		
		return new Building(buildingTiles);
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
