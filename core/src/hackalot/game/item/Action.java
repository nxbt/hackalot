package hackalot.game.item;

import hackalot.game.map.Tile;

public class Action {


    public Action() {}


    public void doChop(String[] compatibleTiles, Tile tile){
        if(canAct(compatibleTiles, tile)){
//
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
