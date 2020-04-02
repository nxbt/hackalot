package hackalot.game.map;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;

import hackalot.game.crafting.Blueprint;
import hackalot.game.crafting.RecipeUpdateReceiver;
import hackalot.game.crafting.RecipeUpdateSender;
import hackalot.game.item.Item;

public class Map implements MapUpdateReceiver, MapInfoProvider, RecipeUpdateSender {
	
	private static final Texture tileTextures = new Texture("tilemap.png");
	private static final TextureRegion wood = new TextureRegion(tileTextures, 0, 0, 32, 32);
	private static final TextureRegion bricks = new TextureRegion(tileTextures, 32, 0, 32, 32);
	private static final TextureRegion grass = new TextureRegion(tileTextures, 32*6, 0, 32, 32);
	
	private int width;
	private int height;
	
	private Group actor;
	
	private Tile[][] tilemap;
	
	private RecipeUpdateReceiver receiver;
	
	public Map(int width, int height)  {
		
		actor = new Group();
		this.tilemap = new Tile[width][height];
		this.width = width;
		this.height = height;
		for(int x = 0; x < width; x++)
			for(int y = 0; y < height; y++) {
				Sprite sprite = new Sprite(grass);
				tilemap[x][y] = new Tile(sprite, x, y);
				actor.addActor(tilemap[x][y].getActor());
			}
	}
	
	// should be called whenever a tile is updated, to update the state of the map.
	private void updateTile(int x, int y) {
		getRecipeUpdateReceiver().updateBlueprints(x, y);
		// in future, handle hitbox changes, etc.
	}
	
	public Tile getTile(int x, int y) {
		return tilemap[x][y];
	}
	
	public Actor getActor() {
		return actor;
	}

	@Override
	public void setItem(int x, int y, Item item) {
		tilemap[x][y].setItem(item);
		updateTile(x, y);
	}

	@Override
	public void setName(int x, int y, String name) {
		tilemap[x][y].setName(name);
		updateTile(x, y);
		
	}

	@Override
	public void setBuildingTile(int x, int y, BuildingTile buildingTile) {
		tilemap[x][y].setBuildingTile(buildingTile);
		updateTile(x, y);
	}

	@Override
	public void setReceiver(RecipeUpdateReceiver receiver) {
		this.receiver = receiver;
		
	}

	@Override
	public RecipeUpdateReceiver getRecipeUpdateReceiver() {
		return receiver;
	}
}
