package hackalot.game.crafting;

import hackalot.game.item.Item;
import hackalot.game.map.BuildingTile;
import hackalot.game.map.MapUpdateReceiver;
import hackalot.game.map.MapUpdateSender;

public class TileUpdater implements MapUpdateSender {
	
	private String name;
	private Item item;
	private BuildingTile buildingTile;
	
	private MapUpdateReceiver receiver;
	
	public TileUpdater(String name, Item item, BuildingTile buildingTile) {
		this.name = name;
		this.item = item;
		this.buildingTile = buildingTile;
	}
	
	public void update(int x, int y) {
		getMapUpdateReceiver().setName(x, y, name);
		getMapUpdateReceiver().setItem(x, y, item);
		getMapUpdateReceiver().setBuildingTile(x, y, buildingTile);
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
