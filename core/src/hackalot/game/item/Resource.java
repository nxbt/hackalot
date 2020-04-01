package hackalot.game.item;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Resource extends Item{

    private String resourceName;
    private int reasourceSize;

    public Resource(Sprite imageFilePath, String resourceName, int resourceSize){
        super(imageFilePath);
        this.resourceName = resourceName;
        this.reasourceSize = resourceSize;
    }



}
