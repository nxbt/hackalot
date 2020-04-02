package hackalot.game.state;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import hackalot.game.crafting.Blueprint;
import hackalot.game.item.Item;
import hackalot.game.item.Resource;
import com.badlogic.gdx.math.Vector2;
import hackalot.game.entity.Entity;
import hackalot.game.entity.Player;
import hackalot.game.map.Map;
import hackalot.game.stage.StageManager;
import hackalot.game.stage.StageUpdateReceiver;

import java.util.ArrayList;
import java.util.List;


public class PlayState extends State {

	private Map map;
	private int tickCount;
	private List<Entity> entities;
	private StageUpdateReceiver stageManager;
	
	
	public PlayState() {
		
		//our state manager instantiation
		stageManager = new StageManager();
		stageManager.setViewport(new ScreenViewport());
		

		map = new Map(100, 100 );
		entities = new ArrayList<Entity>();

		tickCount = 0;
		stageManager.addActor( map.getActor() );
		entities.add( new Player( new Vector2( 3, 3 ) ) );
	}

	public PlayState(StageManager manager) {

		/*
		 * TODO: If this constructor is necessary,
		 * add code necessary for custom stage manager
		 */
			
	}
	
	@Override
	public void tick() {
		
		if (tickCount % 60 == 0) {
			Item wood = new Resource(new Sprite(Item.wood), "wood", 1);
			if (tickCount / 60 == 1) { 
				map.getTile(3, 3).setItem(wood);
				map.updateTile(3, 3);
			}
			if (tickCount / 60 == 2) {
				map.getTile(3, 4).setItem(wood);
				map.updateTile(3, 4);
			}
			if (tickCount / 60 == 3) {
				map.getTile(3, 5).setItem(wood);
				map.updateTile(3, 5);
			}

			if (tickCount / 60 == 4) {
				map.getTile(4, 3).setItem(wood);
				map.updateTile(4, 3);
			}
			if (tickCount / 60 == 5) {
				map.getTile(4, 4).setItem(wood);
				map.updateTile(4, 4);
			}
			if (tickCount / 60 == 6) {
				map.getTile(4, 5).setItem(wood);
				map.updateTile(4, 5);
			}

			if (tickCount / 60 == 7) {
				map.getTile(5, 3).setItem(wood);
				map.updateTile(5, 3);
			}
			if (tickCount / 60 == 8) {
				map.getTile(5, 4).setItem(wood);
				map.updateTile(5, 4);
			}
			if (tickCount / 60 == 9) {
				map.getTile(5, 5).setItem(wood);
				map.updateTile(5, 5);
			}
			if (tickCount / 60 == 10) {
				Blueprint blueprint = map.getBuildableBlueprint(3, 3, wood);
				blueprint.build(map);
			}
		}
		
		tickCount++;
		
		stageManager.act();
	}

	@Override
	public void draw() {
		stageManager.draw();
	}



	@Override
	public void resize( int width, int height ) {}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}


}
