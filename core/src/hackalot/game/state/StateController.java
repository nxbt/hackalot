package hackalot.game.state;

public class StateController {

	private State state;

	public StateController() {

		this.state = new PlayState();
	}

	public void changeState( State newState ) {

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
