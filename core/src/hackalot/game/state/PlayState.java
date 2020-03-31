package hackalot.game.state;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import hackalot.game.crafting.Blueprint;
import hackalot.game.item.Item;
import hackalot.game.item.Resource;
import hackalot.game.map.Map;

public class PlayState extends State {

	private Stage stage;
	private Map map;
//	private ArrayList<Entity> entities;
	
	private int tickCount;

	public PlayState() {
		stage = new Stage( new ScreenViewport() );

		map = new Map(100, 100 );
//		entities = new ArrayList<Entity>();

		stage.addActor( map.getActor() );
		
		tickCount = 0;
	}

	@Override
	public void tick() {
		stage.act();
		
		if (tickCount % 60 == 0) {
			Item wood = new Resource("wood.png", "wood", 1);
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
	}

	@Override
	public void draw() {
		stage.draw();
	}

	@Override
	public void dispose() {
		stage.dispose();
	}

	@Override
	public void resize( int width, int height ) {
		stage.getViewport().update(width, height, true);
	}


}
