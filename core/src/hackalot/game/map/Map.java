package hackalot.game.map;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;

import hackalot.game.crafting.RecipeManager;

public class Map {
	
	private static final Texture tileTextures = new Texture("tilemap.png");
	private static final TextureRegion wood = new TextureRegion(tileTextures, 0, 0, 32, 32);
	private static final TextureRegion bricks = new TextureRegion(tileTextures, 32, 0, 32, 32);
	
	private int width;
	private int height;
	
	private Group actor;
	
	private Tile[][] tilemap;
	
	private RecipeManager manager;
	
	public Map(int width, int height)  {
		
		manager = new RecipeManager();
		
		actor = new Group();
		this.tilemap = new Tile[width][height];
		this.width = width;
		this.height = height;
		for(int x = 0; x < width; x++)
			for(int y = 0; y < height; y++) {
				Sprite sprite = new Sprite((x * y) % 2 == 0 ? wood : bricks);
				tilemap[x][y] = new Tile(sprite, x, y);
				actor.addActor(tilemap[x][y].getActor());
			}
	}
	
	public void updateTile(int x, int y) {
		
	}
	
	public Tile getTile(int x, int y) {
		return tilemap[x][y];
	}
	
	public Actor getActor() {
		return actor;
	}
}
