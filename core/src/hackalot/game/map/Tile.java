package hackalot.game.map;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

import hackalot.game.SpriteActor;

public class Tile {
	
	private String name;
	private Actor actor;
	
	//private Item item;
	private Building building;
	
	public Tile(Sprite sprite, int x, int y) {
		actor = new SpriteActor(sprite);
		actor.setPosition(32*x, 32*y); // in future, 32 should be Resources.TILE_SIZE
		actor.setWidth(32);
		actor.setHeight(32);
	}
	
	public boolean hasItem() {
		//return this.item != null;
		return false; // delete later
	}
	
	public boolean hasBuilding() {
		return this.building != null;
	}
	
	public Building getBuilding() {
		return building;
	}
	
	public Actor getActor() {
		return actor;
	}
}
