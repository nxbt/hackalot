package hackalot.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import hackalot.game.map.Map;
import hackalot.game.state.StateController;

public class GameMain extends ApplicationAdapter {
	private StateController sc;
	
	@Override
	public void create () {
		
		sc = new StateController();
	}
	
	@Override
	public void resize(int width, int height) {
		sc.resize( width, height );
	}

	@Override
	public void render() {
		sc.tick();
		sc.draw();
	}
	
	@Override
	public void dispose () {
		sc.dispose();
	}
}
