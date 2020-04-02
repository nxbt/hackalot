package hackalot.game.stage;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public interface StageUpdateReceiver {
	
	/**
	 * Adds an actor to the stage
	 * @param actor
	 */
	public void addActor(Actor actor);
	
	/**
	 * Removes an actor from the stage
	 * @param actor
	 */
	public void removeActor(Actor actor);
	
	
	/**
	 * Stage.java functions that are implemented here to be able
	 * to interact with the stage variable in StageManager.java
	 * 
	 */
	public void setViewport(Viewport view);
	public void act();
	public void draw();
}
