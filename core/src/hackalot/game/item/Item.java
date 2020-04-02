package hackalot.game.item;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

import hackalot.game.SpriteActor;

public abstract class Item {

	private static final Texture itemTextures = new Texture("items.png");
	public static final TextureRegion wood = new TextureRegion(itemTextures, 0, 0, 32, 32);
	public static final TextureRegion planks = new TextureRegion(itemTextures, 32, 0, 32, 32);
	public static final TextureRegion clay = new TextureRegion(itemTextures, 64, 0, 32, 32);
	public static final TextureRegion bricks = new TextureRegion(itemTextures, 96, 0, 32, 32);
	public static final TextureRegion wool = new TextureRegion(itemTextures, 128, 0, 32, 32);
	public static final TextureRegion string = new TextureRegion(itemTextures, 160, 0, 32, 32);
	public static final TextureRegion sticks = new TextureRegion(itemTextures, 192, 0, 32, 32);
	
	private Sprite sprite;

    public Item(Sprite sprite){
    	this.sprite = sprite;
    }

	public Actor getActor() {
		return new SpriteActor(sprite);
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Item)) return false;
		Item other = (Item) obj;
		return sprite.equals(other.sprite);
	}

}
