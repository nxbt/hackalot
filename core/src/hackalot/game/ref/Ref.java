package hackalot.game.ref;

import com.badlogic.gdx.scenes.scene2d.Stage;

import hackalot.game.state.StateManager;

public class Ref {
	public static final Ref R = new Ref();

	public final State state;
	public final Key key;
	public final Player player;

	public StateManager sc;
	public Stage stage;

	public Ref() {
		state = new State();
		key = new Key();
		player = new Player();
	}



}
