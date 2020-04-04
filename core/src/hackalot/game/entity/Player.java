package hackalot.game.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import hackalot.game.SpriteActor;
import hackalot.game.command.InputController;
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
		
		// This feels like magic, we don't store a reference to the InputController, and yet...
		// it controls.
		new InputController(this);

		this.controller = new PlayerController();

		setMaxHealth( Ref.Player.MAX_HEALTH );
		setActor( new SpriteActor( new Sprite(new TextureRegion(new Texture("player.png"), 0, 0, 32, 32))));
	}
	
}
