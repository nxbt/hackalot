package hackalot.game.map;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;

import hackalot.game.SpriteActor;
import hackalot.game.item.Item;

public class Tile {
	
	private String name;

	private Group actor;
	
	private Item item;
	
	private BuildingTile buildingTile;
	
	public Tile(Sprite sprite, int x, int y) {
		actor = new Group();
		Actor tileActor = new SpriteActor(sprite);
		tileActor.setZIndex(1);
		actor.addActor(tileActor);
		actor.setPosition(32*x, 32*y); // in future, 32 should be Resources.TILE_SIZE
		tileActor.setWidth(32);
		tileActor.setHeight(32);
	}
	
	public Actor getActor() {
		return actor;
	}
	
	public boolean hasItem() {
		//return this.item != null;
		return false; // delete later
	}
	
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		System.out.println("Set item to wood");
		if(this.item != null) actor.removeActor(this.item.getActor());
		this.item = item;
		if(this.item != null) {
			Actor itemActor = this.item.getActor();
			itemActor.setWidth(32);
			itemActor.setHeight(32);
			actor.addActor(itemActor);
		}
		actor.setZIndex(0);
	}
	
	public boolean hasBuildingTile() {
		return this.buildingTile != null;
	}

	public BuildingTile getBuildingTile() {
		return buildingTile;
	}

	public void setBuildingTile(BuildingTile buildingTile) {
		this.buildingTile = buildingTile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
