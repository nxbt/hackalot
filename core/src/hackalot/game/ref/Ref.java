package hackalot.game.ref;

import com.badlogic.gdx.Input;
import hackalot.game.state.StateManager;

public class Ref {
	public static class Player {
		public static final int MAX_HEALTH = 3;
	}

	public static class Key {
		public static final int UP = Input.Keys.W;
		public static final int LEFT = Input.Keys.A;
		public static final int DOWN = Input.Keys.S;
		public static final int RIGHT = Input.Keys.D;

		public static final int INTERACT = Input.Keys.SPACE;
	}
}
