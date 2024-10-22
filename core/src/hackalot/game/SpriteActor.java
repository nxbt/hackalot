package hackalot.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class SpriteActor extends Actor {
	
	Sprite sprite;

	public SpriteActor() {}

	public SpriteActor(Sprite sprite) {
		this.sprite = sprite;
	}

	public SpriteActor( String filepath ) {
		sprite = new Sprite( new Texture( filepath ) );
	}

	public void setSprite( Sprite sprite ) {
		this.sprite = sprite;
	}

	@Override
	public void draw (Batch batch, float parentAlpha) {
		if( sprite == null ) return;

		Color color = getColor();
		batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
		batch.draw(sprite, getX(), getY(), getOriginX(), getOriginY(),
			getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
	}
	
}
