package hackalot.game.ref;

import hackalot.game.state.StateController;

public class Ref {
	public static final Ref R = new Ref();

	public final State state;
	public final Key key;
	public final Player player;

	public StateController sc;

	public Ref() {
		state = new State();
		key = new Key();
		player = new Player();
	}



}
