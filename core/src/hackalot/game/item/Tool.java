package hackalot.game.item;


import hackalot.game.map.Tile;

public class Tool extends Item{

    private String toolName;
    private String[] compatibleTiles;
    private Action action;

    public Tool(String imageFilePath, String toolName, String[] compatibleTiles, Action action){
        super(imageFilePath);
        this.toolName = toolName;
        this.compatibleTiles = compatibleTiles;
        this.action = action;
    }

    public String[] getCompatibleTiles(){
        return compatibleTiles;
    }

    public void Interact(Tile tile){
        if(this.toolName == "axe"){
            action.doChop(this.compatibleTiles, tile);
        }
    }
}
