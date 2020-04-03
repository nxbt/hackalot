package hackalot.game.entity;

import com.badlogic.gdx.math.Vector2;
import hackalot.game.SpriteActor;
import hackalot.game.controller.PlayerController;
import hackalot.game.ref.Ref;

/**
 * Will represent the player
 * @author HANHAN
 *
 */
public class Player extends Character {

	public Player( Vector2 position ) {
		super( position );

		this.controller = new PlayerController();

		setMaxHealth( Ref.Player.MAX_HEALTH );
		setActor( new SpriteActor( "badlogic.jpg" ) );
	}

	@Override
	public void update() {

	}
	
	private void interact() {
		
	}
	
}
