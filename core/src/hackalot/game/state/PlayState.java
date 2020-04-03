package hackalot.game.state;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import hackalot.game.Drawable;
import hackalot.game.Drawer;
import hackalot.game.Updatable;
import hackalot.game.Updater;
import hackalot.game.crafting.Blueprint;
import hackalot.game.entity.EntityManager;
import hackalot.game.crafting.RecipeBuilder;
import hackalot.game.crafting.RecipeInfoProvider;
import hackalot.game.crafting.RecipeManager;
import hackalot.game.item.Item;
import hackalot.game.item.Resource;
import hackalot.game.map.*;
import hackalot.game.stage.StageManager;
import hackalot.game.stage.StageUpdateReceiver;
import hackalot.game.stage.StageUpdateSender;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * State for game-play sections
 * @author Brendan
 */
public class PlayState extends State implements Updater<Updatable>, Drawer<Drawable>, MapUpdateSender, StageUpdateSender {

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

		// set the appropriate update receivers
		setReceiver( map );
		setReceiver( stageManager );

		getStageUpdateReceiver().addActor( map.getActor() );
//		entities.add( new Player( new Vector2( 3, 3 ) ) );

		tickCount = 0;

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

		MapUpdateReceiver mapReceiver = getMapUpdateReceiver();

		if (tickCount % 60 == 0) {
			Item wood = new Resource(new Sprite(Item.wood), "wood", 1);
			if (tickCount / 60 == 1) { 
				mapReceiver.setItem(3, 3, wood);
			}
			if (tickCount / 60 == 2) {
				mapReceiver.setItem(3, 4, wood);
			}
			if (tickCount / 60 == 3) {
				mapReceiver.setItem(3, 5, wood);
			}

			if (tickCount / 60 == 4) {
				mapReceiver.setItem(4, 3, wood);
			}
			if (tickCount / 60 == 5) {
				mapReceiver.setItem(4, 4, wood);
			}
			if (tickCount / 60 == 6) {
				mapReceiver.setItem(4, 5, wood);
			}

			if (tickCount / 60 == 7) {
				mapReceiver.setItem(5, 3, wood);
			}
			if (tickCount / 60 == 8) {
				mapReceiver.setItem(5, 4, wood);
			}
			if (tickCount / 60 == 9) {
				mapReceiver.setItem(5, 5, wood);
			}
			if (tickCount / 60 == 10) {
				Blueprint blueprint = recipeManager.getBuildableBlueprint(3, 3, wood);
				blueprint.build();
			}
		}
		
		tickCount++;
		
		getStageUpdateReceiver().act();
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
		getStageUpdateReceiver().dispose();
	}

	/**
	 * Called when the window is resized
	 * @param width The new window width
	 * @param height The new window height
	 */
	@Override
	public void resize( int width, int height ) {
		getStageUpdateReceiver().resize( width, height );
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

	/**
	 * Sets the StageUpdateReceiver
	 * @param receiver The StageUpdateReceiver to use
	 */
	@Override
	public void setReceiver( StageUpdateReceiver receiver ) {
		this.stageUpdateReceiver = receiver;
	}

	/**
	 * Gets the StageUpdateReceiver
	 * @return The StageUpdateReceiver
	 */
	@Override
	public StageUpdateReceiver getStageUpdateReceiver() {
		return this.stageUpdateReceiver;
	}

	/**
	 * Sets the MapUpdateReceiver
	 * @param receiver The MapUpdateReceiver to use
	 */
	@Override
	public void setReceiver( MapUpdateReceiver receiver ) {
		this.mapUpdateReceiver = receiver;
	}

	/**
	 * Gets the MapUpdateReceiver
	 * @return The MapUpdateReceiver
	 */
	@Override
	public MapUpdateReceiver getMapUpdateReceiver() {
		return this.mapUpdateReceiver;
	}
}
