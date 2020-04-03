package hackalot.game;

import com.badlogic.gdx.ApplicationAdapter;
import hackalot.game.state.StateManager;

import static hackalot.game.ref.Ref.R;


public class GameMain extends ApplicationAdapter {

	private StateManager stateManager;

	@Override
	public void create () {
		this.stateManager = new StateManager();
	}

	@Override
	public void render() {
		this.stateManager.update();
		this.stateManager.draw();
	}

	@Override
	public void resize(int width, int height) {
		this.stateManager.resize( width, height );
	}

	@Override
	public void dispose () {
		this.stateManager.dispose();
	}
}
