package hackalot.game;

import com.badlogic.gdx.ApplicationAdapter;

import hackalot.game.ref.Ref;
import hackalot.game.state.StateManager;

public class GameMain extends ApplicationAdapter {

	private StateManager stateManager;

	@Override
	public void create () {
		Ref.Resources.load("items.png", 32, 32, "item", new String[] {"log", "planks", "clay", "bricks", "wool", "string", "sticks"});
		Ref.Resources.load("tilemap.png", 32, 32, "tile", new String[] {"wood", "bricks", "red", "pink", "yellow", "blue", "green"});
		
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
