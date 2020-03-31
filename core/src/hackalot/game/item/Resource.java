package hackalot.game.item;

import hackalot.game.map.Tile;

public class Resource extends Item{

    private String resourceName;
    private int reasourceSize;

    public Resource(String imageFilePath, String resourceName, int resourceSize){
        super(imageFilePath);
        this.resourceName = resourceName;
        this.reasourceSize = resourceSize;
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
