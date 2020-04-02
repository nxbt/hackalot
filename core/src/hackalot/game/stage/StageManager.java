package hackalot.game.stage;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class StageManager implements StageUpdateReceiver{
	private Stage stage;

	/**
	 * Creates an empty stage
	 */
	public StageManager () {
		stage = new Stage();
	}
	
	
	@Override
	public void addActor(Actor actor) {
		// TODO Auto-generated method stub
		stage.addActor(actor);;
		
	}

	/**
	 * Removes actor from any stage it may be in
	 * @param Actor
	 */
	@Override
	public void removeActor(Actor actor) {
		actor.remove();
		
	}

	/**
	 * Takes in a viewport and sets the stage to it
	 * @param ScreenViewport
	 */
	@Override
	public void setViewport(Viewport view) {
		stage.setViewport(view);
	}


	@Override
	public void act() {
		stage.act();
		
	}


	@Override
	public void draw() {
		stage.draw();
		
	}

}
