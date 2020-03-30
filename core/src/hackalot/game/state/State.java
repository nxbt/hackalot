package hackalot.game.state;

public abstract class State {

	public abstract void tick();
	public abstract void draw();
	public abstract void dispose();
	public abstract void resize( int width, int height );
}
