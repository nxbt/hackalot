package hackalot.game.item;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import hackalot.game.map.Tile;

public class Action {


    public static void doChop(String[] compatibleTiles, Tile tile){
        if(canAct(compatibleTiles, tile)){
            Item wood = new Resource(new Sprite(new Texture("/image_file_path/wood")), "wood", 1);
            tile.setItem(wood);
        }
    }

    public static void doDig(String[] compatibleTiles, Tile tile){
        if(canAct(compatibleTiles, tile)){
            Item mud = new Resource(new Sprite(new Texture("/image_file_path/mud")), "mud", 1);
            tile.setItem(mud);
        }
    }

    public static void doMine(String[] compatibleTiles, Tile tile){
        if(canAct(compatibleTiles, tile)){
            Item stone = new Resource(new Sprite(new Texture("/image_file_path/mud")), "stone", 1);
            tile.setItem(stone);
        }
    }


    public static boolean canAct(String[] compatibleTiles, Tile tile){
        for(int i = 0; i < compatibleTiles.length; i++){
            if(compatibleTiles[i].equals(tile.getName())) {
                return true;
            }
        }
        return false;
    }
}
