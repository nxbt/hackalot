package hackalot.game.ref;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Ref {
	public static class Player {
		public static final int MAX_HEALTH = 3;
		
		public static final int MOVE_SPEED = 6;
		
		public static final float REACH_DISTANCE = 1.5f;
	}

	public static class Key {
		public static final int UP = Input.Keys.W;
		public static final int LEFT = Input.Keys.A;
		public static final int DOWN = Input.Keys.S;
		public static final int RIGHT = Input.Keys.D;

		public static final int INTERACT = Input.Keys.SPACE;
		public static final int CHANGE_ITEM = Input.Keys.E;
	}
	
	public enum Direction {
		CENTER(new Vector2(0, 0)),
		LEFT(new Vector2(-1, 0)),
		RIGHT(new Vector2(1, 0)),
		UP(new Vector2(0, 1)),
		DOWN(new Vector2(0, -1));
		
		private Vector2 dir;
		
		private Direction(Vector2 dir) {
			this.dir = dir;
		}
		
		public Vector2 getVector2() {
			return dir;
		}
	}
	
	public static class Resources {
		private static final AssetManager manager = new AssetManager();
		
		private final static Map<String, Map<String, TextureRegion>> map = new HashMap<String, Map<String, TextureRegion>>();
		
		/**
		 * Loads some TextureRegions from a file into memory.
		 * @param filePath The path to the file to load.
		 * @param textureWidths The width of each texture in the file.
		 * @param textureHeights The height of each texture in the file.
		 * @param groupName The groupName of these textures, will be used to access the loaded TextureRegions.
		 * @param names Array of names of each texture, starting in the upper left and going first across and then down.
		 * 		  Will be used to access the loaded TextureRegions.
		 */
		public static void load(String filePath, int textureWidths, int textureHeights, String groupName, String[] names) {
			manager.load(filePath, Texture.class);
			manager.finishLoading();
			
			if(!map.containsKey(groupName)) map.put(groupName, new HashMap<String, TextureRegion>());
			Map<String, TextureRegion> group = map.get(groupName);
			
			Texture texture = manager.get(filePath, Texture.class);
			int i = 0;
			for(int y = 0; y < texture.getHeight(); y+=textureHeights) {
				for(int x = 0; x < texture.getWidth(); x+=textureWidths) {
					if(i == names.length) break;
					group.put(names[i], new TextureRegion(texture, x, y, textureWidths, textureHeights));
					i++;
				}
			}
		}
		
		/**
		 * Gets a previously loaded TextureRegion.
		 * @param groupName The groupName of the TextureRegion set during loading.
		 * @param name The name of the TextureRegion set during loading.
		 * @return The TextureRegion loaded with the groupName and name.
		 */
		public static TextureRegion getTextureRegion(String groupName, String name) {
			return map.get(groupName).get(name);
		}
		
		public static void dispose() {
			manager.dispose();
		}
	}
}
