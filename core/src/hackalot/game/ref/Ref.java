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



}
