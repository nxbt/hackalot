package hackalot.game.item;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

import hackalot.game.SpriteActor;

public abstract class Item {
    private String imageFilePath;

    public Item(String imageFilePath){
        this.imageFilePath = imageFilePath;
    }

	public Actor getActor() {
		return new SpriteActor(new Sprite(new Texture(imageFilePath)));
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Item)) return false;
		Item other = (Item) obj;
		return imageFilePath.equals(other.imageFilePath);
	}

}
