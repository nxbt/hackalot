package hackalot.game.map;

//single tile of a building
public class BuildingTile {
	private Building building; // the building this tile is a part of. Circular dependency is not good.  Maybe use MVP Pattern?
	private int hp;
	private Item dropItem; // item that should drop when this buildingTile is deconstructed.
	
	private void destroy() {
		
	}
}
