package hackalot.game.ref;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import hackalot.game.state.StateController;

public class Ref {
	public static final Ref R = new Ref();

	public final State state;
	public final Key key;

	public final StateController sc;

	public Ref() {
		state = new State();
		key = new Key();

		sc = new StateController();
	}



}
