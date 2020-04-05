package hackalot.game.map;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;

import hackalot.game.SpriteActor;
import hackalot.game.item.Item;
import hackalot.game.item.Resource;

public class Tile {
	
	private String name;

	private Group actor;
	
	private Actor tileActor;
	private Actor itemActor;
	private Actor buildingTileActor;
	
	private Item item;
	
	private BuildingTile buildingTile;
	
	public Tile(Sprite sprite, int x, int y) {
		actor = new Group();
		
		tileActor = new SpriteActor(sprite);
		tileActor.setZIndex(1);
		tileActor.setWidth(32);
		tileActor.setHeight(32);
		
		actor.addActor(tileActor);
		actor.setPosition(32*x, 32*y); // in future, 32 should be Resources.TILE_SIZE
	}
	
	public Actor getActor() {
		return actor;
	}
	
	public boolean hasItem() {
		return this.item != null;
	}
	
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		System.out.println("Set item to " + (item == null ? "Null" : ((Resource) item).getName()));
		if(this.item != null) actor.removeActor(this.itemActor);
		this.item = item;
		if(this.item != null) {
			itemActor = this.item.getActor();
			itemActor.setWidth(32);
			itemActor.setHeight(32);
			itemActor.setZIndex(0);
			
			actor.addActor(itemActor);
		}
	}
	
	public boolean hasBuildingTile() {
		return this.buildingTile != null;
	}

	public BuildingTile getBuildingTile() {
		return buildingTile;
	}

	public void setBuildingTile(BuildingTile buildingTile) {
		System.out.println("Setting builing to wall.");
		if(this.buildingTile != null) actor.removeActor(this.buildingTileActor);
		this.buildingTile = buildingTile;
		if(this.buildingTile != null) {
			buildingTileActor = this.buildingTile.getActor();
			buildingTileActor.setWidth(32);
			buildingTileActor.setHeight(32);
			buildingTileActor.setZIndex(0);
			
			actor.addActor(buildingTileActor);
		}
		this.buildingTile = buildingTile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
