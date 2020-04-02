package hackalot.game.item;

import com.badlogic.gdx.graphics.g2d.Sprite;

import hackalot.game.map.Tile;

public class Action {


    public Action() {}


    public void doChop(String[] compatibleTiles, Tile tile){
        if(canAct(compatibleTiles, tile)){
            Resource wood = new Resource(new Sprite(Item.wood), "wood", 1);
            tile.setItem(wood);
        }
    }

    public void doDig(String[] compatibleTiles, Tile tile){
        if(canAct(compatibleTiles, tile)){
            Resource mud = new Resource(new Sprite(Item.clay), "mud", 1);
            tile.setItem(mud);
        }
    }

    public void doMine(String[] compatibleTiles, Tile tile){
        if(canAct(compatibleTiles, tile)){
            Resource stone = new Resource(new Sprite(Item.bricks), "stone", 1);
            tile.setItem(stone);
        }
    }


    public boolean canAct(String[] compatibleTiles, Tile tile){
        for(int i = 0; i < compatibleTiles.length; i++){
            if(compatibleTiles[i].equals(tile.getName())) {
                return true;
            }
        }
        return false;
    }
}
