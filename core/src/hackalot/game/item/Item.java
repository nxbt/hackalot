package hackalot.game.item;


import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

import hackalot.game.SpriteActor;


public abstract class Item {
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
