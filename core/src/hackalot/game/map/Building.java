package hackalot.game.map;

import java.util.List;

import hackalot.game.crafting.Craftable;

// coordinates the BuildingTiles of a single Building
public abstract class Building implements Craftable {
	private List<BuildingTile> buildingTiles; // keeps track of all the tiles in this building;
	private boolean operational;
	
	public Building() {
		operational = true;
	}
	
	private boolean isOperational() {
		return operational;
	}
	
	public void tileDestroyed() {
		operational = false;
	}
}
