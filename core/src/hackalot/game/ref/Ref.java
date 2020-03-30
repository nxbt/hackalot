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

	public class State {
		public final hackalot.game.state.State default_state;

		public State() {
			default_state = new hackalot.game.state.MenuState();
		}
	}

	public class Key {
		public final int up;
		public final int left;
		public final int down;
		public final int right;

		public final int interact;

		public Key() {
			up = Input.Keys.W;
			left = Input.Keys.A;
			down = Input.Keys.S;
			right = Input.Keys.D;

			interact = Input.Keys.SPACE;
		}
	}

}
