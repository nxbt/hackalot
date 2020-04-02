package hackalot.game.map;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

import hackalot.game.SpriteActor;
import hackalot.game.item.Item;

//single tile of a building
public class BuildingTile {
	private String name;
	private Building building; // the building this tile is a part of. Circular dependency is not good.  Maybe use MVP Pattern?
	private int HP;
	private Item dropItem; // item that should drop when this buildingTile is deconstructed.
	private boolean destroyed;
	private TextureRegion textureRegion;
	
	public BuildingTile(String name, TextureRegion textureRegion) {
		this.name = name;
		destroyed = false;
		this.textureRegion = textureRegion;
	}
	
	public void setBuilding(Building building) {
		this.building = building;
	}
	
	private void destroy() {
		destroyed = true;
	}
	
	public boolean isDestroyed() {
		return destroyed;
	}
	
	public void setHealth(int HP) {
		this.HP = HP;
		if(this.HP < 1) destroy();
	}
	
	public int getHealth() {
		return HP;
	}

	public Actor getActor() {
		return new SpriteActor(new Sprite(textureRegion));
	}
	
}
