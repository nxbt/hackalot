package hackalot.game.item;


import com.badlogic.gdx.graphics.g2d.Sprite;
import hackalot.game.map.Tile;

public class Tool extends Item{

    private String toolName;
    private String[] compatibleTiles;

    public Tool(Sprite imageFilePath, String toolName, String[] compatibleTiles){
        super(imageFilePath);
        this.toolName = toolName;
        this.compatibleTiles = compatibleTiles;
    }

    public String[] getCompatibleTiles(){
        return compatibleTiles;
    }

    public void interact(Tile tile){
        if(this.toolName.equals("axe")){
            Action.doChop(this.compatibleTiles, tile);
        }
        else if(this.toolName.equals("shovel")){
            Action.doDig(this.compatibleTiles, tile);
        }
        else if(this.toolName.equals("pickaxe")){
            Action.doMine(this.compatibleTiles, tile);
        }
    }
}
