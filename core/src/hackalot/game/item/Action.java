package hackalot.game.item;

import hackalot.game.map.Tile;

public class Action {


    public Action() {}


    public void doChop(String[] compatibleTiles, Tile tile){
        if(canAct(compatibleTiles, tile)){
            Resource wood = new Resource("/image_file_path/wood", "wood", 1);
            tile.setItem(wood);
        }
    }

    public void doDig(String[] compatibleTiles, Tile tile){
        if(canAct(compatibleTiles, tile)){
            Resource mud = new Resource("/image_file_path/mud", "mud", 1);
            tile.setItem(mud);
        }
    }

    public void doMine(String[] compatibleTiles, Tile tile){
        if(canAct(compatibleTiles, tile)){
            Resource stone = new Resource("/image_file_path/stone", "stone", 1);
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
