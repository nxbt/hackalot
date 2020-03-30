package hackalot.game.state;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import hackalot.game.map.Map;

public class PlayState extends State {

	private Stage stage;
	private Map map;
//	private ArrayList<Entity> entities;

	public PlayState() {
		stage = new Stage( new ScreenViewport() );

		map = new Map(100, 100 );
//		entities = new ArrayList<Entity>();

		stage.addActor( map.getActor() );
	}

	@Override
	public void tick() {
		stage.act();
	}

	@Override
	public void draw() {
		stage.draw();
	}

	@Override
	public void dispose() {
		stage.dispose();
	}

	@Override
	public void resize( int width, int height ) {
		stage.getViewport().update(width, height, true);
	}


}
