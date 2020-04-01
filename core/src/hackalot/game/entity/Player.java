package hackalot.game.entity;

import com.badlogic.gdx.math.Vector2;
import hackalot.game.SpriteActor;
import hackalot.game.controller.PlayerController;

import static hackalot.game.ref.Ref.R;

/**
 * Will represent the player
 * @author HANHAN
 *
 */
public class Player extends Character {

	public Player( Vector2 position ) {
		super( position );

		this.controller = new PlayerController();

		setMaxHealth( R.player.max_health );
		setActor( new SpriteActor( "badlogic.jpg" ) );
	}

	@Override
	public void tick() {

	}
	
	private void interact() {
		
	}
	
}
