package hackalot.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.scenes.scene2d.Stage;

import hackalot.game.state.StateManager;

import static hackalot.game.ref.Ref.R;


public class GameMain extends ApplicationAdapter {
	
	@Override
	public void create () {
		R.stage = new Stage();
		R.sc = new StateManager();
	}

	@Override
	public void render() {
		R.sc.update();
		R.sc.draw();
	}

	@Override
	public void resize(int width, int height) {
		R.stage.getViewport().update(width, height, true);
		R.sc.resize( width, height );
	}

	@Override
	public void dispose () {
		R.stage.dispose();
		R.sc.dispose();
	}
}
