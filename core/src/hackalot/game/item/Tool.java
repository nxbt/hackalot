package hackalot.game.item;


import com.badlogic.gdx.graphics.g2d.Sprite;

import hackalot.game.map.Tile;

public class Tool extends Item{

    private String toolName;
    private String[] compatibleTiles;
    private Action action;

    public Tool(Sprite sprite, String toolName, String[] compatibleTiles){
        super(sprite);
        this.toolName = toolName;
        this.compatibleTiles = compatibleTiles;
    }

    public String[] getCompatibleTiles(){
        return compatibleTiles;
    }

    public void interact(Tile tile){
        if(this.toolName == "axe"){
            action.doChop(this.compatibleTiles, tile);
        }
        else if(this.toolName == "shovel"){
            action.doDig(this.compatibleTiles, tile);
        }
        else if(this.toolName == "pickaxe"){
            action.doMine(this.compatibleTiles, tile);
        }
    }
}
