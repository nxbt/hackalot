package hackalot.game.ref;

import hackalot.game.state.StateController;

public class Ref {
	public static final Ref R = new Ref();

	public final State state;

	public final StateController sc;

	public Ref() {
		state = new State();

		sc = new StateController();
	}

	public class State {

		public final hackalot.game.state.State default_state;

		public State() {
			default_state = new hackalot.game.state.MenuState();
		}
	}

}
