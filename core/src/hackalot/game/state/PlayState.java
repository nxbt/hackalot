package hackalot.game.state;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import hackalot.game.crafting.Blueprint;
import hackalot.game.crafting.RecipeBuilder;
import hackalot.game.crafting.RecipeManager;
import hackalot.game.item.Item;
import hackalot.game.item.Resource;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import hackalot.game.entity.Entity;
import hackalot.game.entity.Player;
import hackalot.game.map.Map;

import java.util.ArrayList;
import java.util.List;

import static hackalot.game.ref.Ref.R;

public class PlayState extends State {

	private Map map;
	private int tickCount;
	private List<Entity> entities;

	public PlayState() {
		
		R.stage.setViewport( new ScreenViewport() );

		map = new Map(100, 100 );
		entities = new ArrayList<Entity>();

		tickCount = 0;
		R.stage.addActor( map.getActor() );
		entities.add( new Player( new Vector2( 3, 3 ) ) );
	}

	@Override
	public void tick() {
		
		if (tickCount % 60 == 0) {
			Item wood = new Resource(new Sprite(Item.wood), "wood", 1);
			if (tickCount / 60 == 1) { 
				map.setItem(3, 3, wood);
			}
			if (tickCount / 60 == 2) {
				map.setItem(3, 4, wood);
			}
			if (tickCount / 60 == 3) {
				map.setItem(3, 5, wood);
			}

			if (tickCount / 60 == 4) {
				map.setItem(4, 3, wood);
			}
			if (tickCount / 60 == 5) {
				map.setItem(4, 4, wood);
			}
			if (tickCount / 60 == 6) {
				map.setItem(4, 5, wood);
			}

			if (tickCount / 60 == 7) {
				map.setItem(5, 3, wood);
			}
			if (tickCount / 60 == 8) {
				map.setItem(5, 4, wood);
			}
			if (tickCount / 60 == 9) {
				map.setItem(5, 5, wood);
			}
			if (tickCount / 60 == 10) {
				Blueprint blueprint = map.getBuildableBlueprint(3, 3, wood);
				blueprint.build();
			}
		}
		
		tickCount++;
		
		R.stage.act();
	}

	@Override
	public void draw() {
		R.stage.draw();
	}

	@Override
	public void dispose() {}

	@Override
	public void resize( int width, int height ) {}


}
