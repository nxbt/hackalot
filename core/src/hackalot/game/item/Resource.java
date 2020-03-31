package hackalot.game.item;

import hackalot.game.map.Tile;

public class Resource extends Item{

    private String resourceName;
    private int reasourceSize;
    private Tile location;
    private Action action;

    public Resource(String imageFilePath, String resourceName, int reasourceSize, Tile location, Action action) {
        super(imageFilePath);
        this.resourceName = resourceName;
        this.reasourceSize = reasourceSize;
        this.location = location;
        this.action = action;
    }
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Resource)) return false;
		Resource other = (Resource) obj;
		return resourceName.equals(other.resourceName);
	}
	
	public String getName() {
		return this.resourceName;
	}


}
