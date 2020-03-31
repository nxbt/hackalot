package hackalot.game.item;

import hackalot.game.map.Tile;

public abstract class Item {
    private String imageFilePath;

    public Item(String imageFilePath){
        this.imageFilePath = imageFilePath;
    }

}
