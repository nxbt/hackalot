package hackalot.game.state;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import hackalot.game.entity.Entity;
import hackalot.game.entity.Player;
import hackalot.game.map.Map;

import java.util.ArrayList;
import java.util.List;

import static hackalot.game.ref.Ref.R;

public class PlayState extends State {

	private Map map;
	private List<Entity> entities;

	public PlayState() {
		R.stage.setViewport( new ScreenViewport() );

		map = new Map(100, 100 );
		entities = new ArrayList<Entity>();

		R.stage.addActor( map.getActor() );
		entities.add( new Player( new Vector2( 3, 3 ) ) );
	}

	@Override
	public void tick() {
		R.stage.act();
	}

	@Override
	public void draw() {
		R.stage.draw();
	}

	@Override
	public void dispose() {}

	@Override
	public void resize( int width, int height ) {}


}
