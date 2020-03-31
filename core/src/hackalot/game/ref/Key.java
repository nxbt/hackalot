package hackalot.game.ref;

import com.badlogic.gdx.Input;

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
