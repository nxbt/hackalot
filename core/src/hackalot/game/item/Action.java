package hackalot.game.item;

import hackalot.game.map.Tile;

public class Action {


    public Action() {}


    public void doChop(String[] compatibleTiles, Tile tile){
        if(canAct(compatibleTiles, tile)){
//
        }
    }

    public void putDownItem(Tile tile){
//        TODO: Implement putDown
//        I see there is a commented out "private Item item" in the Tile class. I would probably use this
//        and then set item to be the item the player is putting down. This does assume the Tile class
//        will do the drawing of the item but I think thats ok.

//        tile.setItem(item);
    }

    public boolean canAct(String[] compatibleTiles, Tile tile){
        for(int i = 0; i < compatibleTiles.length; i++){
            if(compatibleTiles[i] == tile.getName()){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }
}
