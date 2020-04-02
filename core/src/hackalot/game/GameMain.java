package hackalot.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import hackalot.game.map.Map;
import hackalot.game.state.StateController;

import static hackalot.game.ref.Ref.R;


public class GameMain extends ApplicationAdapter {
	
	@Override
	public void create () {
		R.stage = new Stage();
		R.sc = new StateController();
	}

	@Override
	public void render() {
		R.sc.tick();
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
