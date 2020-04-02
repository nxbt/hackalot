package hackalot.game.state;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import hackalot.game.crafting.Blueprint;
import hackalot.game.crafting.RecipeBuilder;
import hackalot.game.crafting.RecipeInfoProvider;
import hackalot.game.crafting.RecipeManager;
import hackalot.game.item.Item;
import hackalot.game.item.Resource;
import com.badlogic.gdx.math.Vector2;
import hackalot.game.entity.Entity;
import hackalot.game.entity.Player;
import hackalot.game.map.Map;
import hackalot.game.stage.StageManager;
import hackalot.game.stage.StageUpdateReceiver;

import java.util.ArrayList;
import java.util.List;

/**
 * State for game-play sections
 * @author Brendan
 */
public class PlayState extends State {

	private Map map;
	private int tickCount;
	private List<Entity> entities;
	private StageUpdateReceiver stageManager;
	private RecipeInfoProvider recipeManager;

	/**
	 * Default constructor
	 */
	public PlayState() {
		//our stage manager instantiation
		stageManager = new StageManager();
		stageManager.setViewport(new ScreenViewport());

		map = new Map(100, 100 );
		entities = new ArrayList<Entity>();

		tickCount = 0;
		stageManager.addActor( map.getActor() );
		entities.add( new Player( new Vector2( 3, 3 ) ) );

		RecipeManager recipeManager = new RecipeManager();
		recipeManager.setProvider(map);
		recipeManager.setReceiver(map);
		recipeManager.addRecipe(RecipeBuilder.getBarnRecipe());
		
		this.recipeManager = recipeManager;
		
		map.setReceiver(recipeManager);
	}

	/**
	 * Updates all game-play elements
	 */
	@Override
	public void update() {
		
		if (tickCount % 60 == 0) {
			Item wood = new Resource(new Sprite(Item.wood), "wood", 1);
			if (tickCount / 60 == 1) { 
				map.setItem(3, 3, wood);
			}
			if (tickCount / 60 == 2) {
				map.setItem(3, 4, wood);
			}
			if (tickCount / 60 == 3) {
				map.setItem(3, 5, wood);
			}

			if (tickCount / 60 == 4) {
				map.setItem(4, 3, wood);
			}
			if (tickCount / 60 == 5) {
				map.setItem(4, 4, wood);
			}
			if (tickCount / 60 == 6) {
				map.setItem(4, 5, wood);
			}

			if (tickCount / 60 == 7) {
				map.setItem(5, 3, wood);
			}
			if (tickCount / 60 == 8) {
				map.setItem(5, 4, wood);
			}
			if (tickCount / 60 == 9) {
				map.setItem(5, 5, wood);
			}
			if (tickCount / 60 == 10) {
				Blueprint blueprint = recipeManager.getBuildableBlueprint(3, 3, wood);
				blueprint.build();
			}
		}
		
		tickCount++;
		
		stageManager.act();
	}

	/**
	 * Draws all game-play elements
	 */
	@Override
	public void draw() {
		stageManager.draw();
	}

	/**
	 * Releases resources when the play state is destroyed
	 */
	@Override
	public void dispose() {
		//TODO: stageManager.dispose();
	}

	/**
	 * Called when the window is resized
	 * @param width The new window width
	 * @param height The new window height
	 */
	@Override
	public void resize( int width, int height ) {
		//TODO: stageManager.resize( width, height );
	}

}
