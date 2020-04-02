package hackalot.game.state;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import hackalot.game.crafting.Blueprint;
import hackalot.game.item.Item;
import hackalot.game.item.Resource;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import hackalot.game.entity.Entity;
import hackalot.game.entity.Player;
import hackalot.game.map.Map;

import java.util.ArrayList;
import java.util.List;

import static hackalot.game.ref.Ref.R;

/**
 * State for game-play sections
 * @author Brendan
 */
public class PlayState extends State {

	private Map map;
	private int tickCount;
	private List<Entity> entities;

	/**
	 * Default constructor
	 */
	public PlayState() {
		R.stage.setViewport( new ScreenViewport() );

		map = new Map(100, 100 );
		entities = new ArrayList<Entity>();

		tickCount = 0;
		R.stage.addActor( map.getActor() );
		entities.add( new Player( new Vector2( 3, 3 ) ) );
	}

	/**
	 * Updates all game-play elements
	 */
	@Override
	public void update() {
		
		if (tickCount % 60 == 0) {
			Item wood = new Resource(new Sprite(Item.wood), "wood", 1);
			if (tickCount / 60 == 1) { 
				map.getTile(3, 3).setItem(wood);
				map.updateTile(3, 3);
			}
			if (tickCount / 60 == 2) {
				map.getTile(3, 4).setItem(wood);
				map.updateTile(3, 4);
			}
			if (tickCount / 60 == 3) {
				map.getTile(3, 5).setItem(wood);
				map.updateTile(3, 5);
			}

			if (tickCount / 60 == 4) {
				map.getTile(4, 3).setItem(wood);
				map.updateTile(4, 3);
			}
			if (tickCount / 60 == 5) {
				map.getTile(4, 4).setItem(wood);
				map.updateTile(4, 4);
			}
			if (tickCount / 60 == 6) {
				map.getTile(4, 5).setItem(wood);
				map.updateTile(4, 5);
			}

			if (tickCount / 60 == 7) {
				map.getTile(5, 3).setItem(wood);
				map.updateTile(5, 3);
			}
			if (tickCount / 60 == 8) {
				map.getTile(5, 4).setItem(wood);
				map.updateTile(5, 4);
			}
			if (tickCount / 60 == 9) {
				map.getTile(5, 5).setItem(wood);
				map.updateTile(5, 5);
			}
			if (tickCount / 60 == 10) {
				Blueprint blueprint = map.getBuildableBlueprint(3, 3, wood);
				blueprint.build(map);
			}
		}
		
		tickCount++;
		
		R.stage.act();
	}

	/**
	 * Draws all game-play elements
	 */
	@Override
	public void draw() {
		R.stage.draw();
	}

	/**
	 * Releases resources when the play state is destroyed
	 */
	@Override
	public void dispose() {}

	/**
	 * Called when the window is resized
	 * @param width The new window width
	 * @param height The new window height
	 */
	@Override
	public void resize( int width, int height ) {}


}
