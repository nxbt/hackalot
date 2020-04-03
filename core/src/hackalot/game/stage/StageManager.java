package hackalot.game.stage;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import hackalot.game.Drawable;

public class StageManager implements StageUpdateReceiver, Drawable {
	private Stage stage;

	/**
	 * Creates an empty stage
	 */
	public StageManager () {
		stage = new Stage();
	}
	
	
	@Override
	public void addActor(Actor actor) {
		stage.addActor(actor);
	}

	/**
	 * Removes actor from any stage it may be in
	 * @param actor the actor to be removed
	 */
	@Override
	public void removeActor(Actor actor) {
		actor.remove();
		
	}

	/**
	 * Takes in a viewport and sets the stage to it
	 * @param view the viewport to change to
	 */
	@Override
	public void setViewport(Viewport view) {
		stage.setViewport(view);
	}


	@Override
	public void act() {
		stage.act();
		
	}

	/**
	 * TODO: is this how we want to handle resize events for stage?
	 * @param width
	 * @param height
	 */
	@Override
	public void resize( int width, int height ) {
		stage.getViewport().update( width, height, true );
	}


	@Override
	public void draw() {
		stage.draw();
		
	}

	/**
	 * TODO: is this how we want to dispose of stage?
	 */
	@Override
	public void dispose() {
		stage.dispose();
	}
}
