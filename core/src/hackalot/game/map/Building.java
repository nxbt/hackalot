package hackalot.game.map;

import java.util.List;

// coordinates the BuildingTiles of a single Building
public class Building {
	private BuildingTile[] buildingTiles; // keeps track of all the tiles in this building;
	private boolean operational;
	
	public Building(BuildingTile[] buildingTiles) {
		operational = true;
		this.buildingTiles = buildingTiles;
		for(BuildingTile buildingTile: buildingTiles) {
			buildingTile.setBuilding(this);
		}
	}
	
	public boolean isOperational() {
		return operational;
	}
	
	public void tileDestroyed() {
		operational = false;
	}
}
