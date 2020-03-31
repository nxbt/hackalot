package hackalot.game.item;

import hackalot.game.map.Tile;

public class Resource extends Item{

    private String resourceName;
    private int reasourceSize;

    public Resource(String imageFilePath, String resourceName, int resourceSize){
        super(imageFilePath);
        this.resourceName = resourceName;
        this.reasourceSize = resourceSize;
    }

}
