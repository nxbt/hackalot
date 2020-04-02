package hackalot.game.state;

import com.badlogic.gdx.scenes.scene2d.Stage;

import static hackalot.game.ref.Ref.R;

public class StateController {

	private State state;

	public StateController() {
		this.state = new PlayState();
	}

	public void changeState( State newState ) {
		R.stage.clear();
		this.state = newState;
	}

	public void tick() {
		state.tick();
	}

	public void draw() {
		state.draw();
	}

	public void resize( int width, int height ) {
		state.resize( width, height );
	}

	public void dispose() {
		state.dispose();
	}
}
