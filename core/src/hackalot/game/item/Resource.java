package hackalot.game.item;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Resource extends Item{

    private String resourceName;
    private int reasourceSize;

    public Resource(Sprite sprite, String resourceName, int resourceSize){
        super(sprite);
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
