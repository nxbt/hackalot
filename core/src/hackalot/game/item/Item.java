package hackalot.game.item;

import com.badlogic.gdx.graphics.g2d.Sprite;

public abstract class Item {
    private Sprite imageFilePath;

    public Item(Sprite imageFilePath){
        this.imageFilePath = imageFilePath;
    }

}
