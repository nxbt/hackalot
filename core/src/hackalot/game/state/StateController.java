package hackalot.game.state;

public class StateController {

	private State state;

	public StateController() {

		this.state = new MenuState();
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
}
