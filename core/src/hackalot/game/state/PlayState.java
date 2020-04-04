package hackalot.game.state;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import hackalot.game.Drawable;
import hackalot.game.Drawer;
import hackalot.game.Updatable;
import hackalot.game.Updater;
import hackalot.game.crafting.Blueprint;
import hackalot.game.crafting.RecipeBuilder;
import hackalot.game.crafting.RecipeInfoProvider;
import hackalot.game.crafting.RecipeManager;
import hackalot.game.entity.EntityManager;
import hackalot.game.entity.Player;
import hackalot.game.item.Item;
import hackalot.game.item.Resource;
import hackalot.game.map.Map;
import hackalot.game.map.MapUpdateReceiver;
import hackalot.game.stage.StageManager;
import hackalot.game.stage.StageUpdateReceiver;

/**
 * State for game-play sections
 * @author Brendan
 */
public class PlayState extends State implements Updater<Updatable>, Drawer<Drawable> {

	private int tickCount;

	private List<Updatable> updatables;
	private List<Drawable> drawables;

	private MapUpdateReceiver mapUpdateReceiver;
	private StageUpdateReceiver stageUpdateReceiver;
	private RecipeInfoProvider recipeManager;

	/**
	 * Default constructor
	 */
	public PlayState() {
		updatables = new ArrayList<>();
		drawables = new ArrayList<>();

		// stage manager initialization
		StageManager stageManager = new StageManager();
		stageManager.setViewport( new ScreenViewport() );

		// entity manager initialization
		EntityManager entityManager = new EntityManager();

		// recipe manager initialization
		RecipeManager recipeManager = new RecipeManager();
    
		// map initialization
		Map map = new Map(100, 100 );

		// add all updatables
		addUpdatable( entityManager );

		// add all drawables
		addDrawable( stageManager );

		stageManager.addActor( map.getActor() );
//		entities.add( new Player( new Vector2( 3, 3 ) ) );

		tickCount = 0;

		recipeManager.setProvider(map);
		recipeManager.setReceiver(map);
		recipeManager.addRecipe(RecipeBuilder.getBarnRecipe());

		this.mapUpdateReceiver = map;
		this.stageUpdateReceiver = stageManager;
		this.recipeManager = recipeManager;
		
		map.setReceiver(recipeManager);
		
		entityManager.setReceiver(stageManager);
		entityManager.setReceiver(map);
		entityManager.setProvider(map);
		
		entityManager.spawn(new Player(new Vector2()));
		
	}

	/**
	 * Updates all game-play elements
	 */
	@Override
	public void update() {
		
		updatables.forEach(u -> u.update());
		
		if (tickCount % 60 == 0) {
			Item wood = new Resource(new Sprite(Item.wood), "wood", 1);
			if (tickCount / 60 == 1) { 
				mapUpdateReceiver.setItem(3, 3, wood);
			}
			if (tickCount / 60 == 2) {
				mapUpdateReceiver.setItem(3, 4, wood);
			}
			if (tickCount / 60 == 3) {
				mapUpdateReceiver.setItem(3, 5, wood);
			}

			if (tickCount / 60 == 4) {
				mapUpdateReceiver.setItem(4, 3, wood);
			}
			if (tickCount / 60 == 5) {
				mapUpdateReceiver.setItem(4, 4, wood);
			}
			if (tickCount / 60 == 6) {
				mapUpdateReceiver.setItem(4, 5, wood);
			}

			if (tickCount / 60 == 7) {
				mapUpdateReceiver.setItem(5, 3, wood);
			}
			if (tickCount / 60 == 8) {
				mapUpdateReceiver.setItem(5, 4, wood);
			}
			if (tickCount / 60 == 9) {
				mapUpdateReceiver.setItem(5, 5, wood);
			}
			if (tickCount / 60 == 10) {
				Blueprint blueprint = recipeManager.getBuildableBlueprint(3, 3, wood);
				if(blueprint != null) blueprint.build();
			}
		}
		
		tickCount++;
		
		stageUpdateReceiver.act();
	}

	/**
	 * Draws all drawables to the screen
	 */
	@Override
	public void draw() {
		Iterator<Drawable> itr = getDrawables();

		while( itr.hasNext() ) {
			itr.next().draw();
		}
	}

	/**
	 * Releases resources when the play state is destroyed
	 */
	@Override
	public void dispose() {
		stageUpdateReceiver.dispose();
	}

	/**
	 * Called when the window is resized
	 * @param width The new window width
	 * @param height The new window height
	 */
	@Override
	public void resize( int width, int height ) {
		stageUpdateReceiver.resize( width, height );
	}

	/**
	 * Adds an updatable to the list of updatables this will update
	 * @param updatable The updatable object to add
	 */
	@Override
	public void addUpdatable( Updatable updatable ) {
		updatables.add( updatable );
	}

	/**
	 * Removes an updatable from the list of updatables this will update
	 * @param updatable The updatable object to remove
	 * @return True if the updatable was successfully removed
	 */
	@Override
	public boolean removeUpdatable( Updatable updatable ) {
		return updatables.remove( updatable );
	}

	/**
	 * Gets an iterator over the updatables this updates
	 * @return An iterator over updatables to update
	 */
	@Override
	public Iterator<Updatable> getUpdatables() {
		return updatables.iterator();
	}

	/**
	 * Adds a drawable to the list of drawables this will draw
	 * @param drawable The drawable object to add
	 */
	@Override
	public void addDrawable( Drawable drawable ) {
		drawables.add( drawable );
	}

	/**
	 * Removes a drawable from the list of drawables this will draw
	 * @param drawable The drawable object to remove
	 * @return True if the drawable was successfully removed
	 */
	@Override
	public boolean removeDrawable( Drawable drawable ) {
		return drawables.remove( drawable );
	}

	/**
	 * Gets an iterator over the list of drawables this will draw
	 * @return An iterator over drawables to draw
	 */
	@Override
	public Iterator<Drawable> getDrawables() {
		return drawables.iterator();
	}
}
