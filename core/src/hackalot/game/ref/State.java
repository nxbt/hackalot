package hackalot.game.ref;

public class State {

	public final hackalot.game.state.State default_state;

	public State() {
		default_state = new hackalot.game.state.MenuState();
	}
}
