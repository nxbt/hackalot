package hackalot.game.state;

import com.badlogic.gdx.utils.Disposable;

public abstract class State implements Disposable {

	public abstract void tick();
	public abstract void draw();
	public abstract void dispose();
	public abstract void resize( int width, int height );
}
