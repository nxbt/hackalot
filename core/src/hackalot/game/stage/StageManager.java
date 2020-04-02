package hackalot.game.stage;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class StageManager implements StageUpdateReceiver{
	private Stage stage;

	/**
	 * Creates an empty stage
	 */
	public StageManager () {
		stage = new Stage();
	}
	
	
	public Stage getStage() {
		return stage;
	}
	
	public StageManager(Stage stage) {
		this.stage = stage;
	}
	
	@Override
	public void addActor(Actor actor) {
		// TODO Auto-generated method stub
		stage.addActor(actor);;
		
	}

	@Override
	public void removeActor(Actor actor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setViewport(ScreenViewport view) {
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
