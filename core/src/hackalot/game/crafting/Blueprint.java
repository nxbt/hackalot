package hackalot.game.crafting;

import com.badlogic.gdx.scenes.scene2d.Actor;

import hackalot.game.item.Item;
import hackalot.game.map.Building;
import hackalot.game.map.Map;
import hackalot.game.map.MapInfoProvider;
import hackalot.game.map.MapInfoQuerier;
import hackalot.game.map.MapUpdateReceiver;
import hackalot.game.map.MapUpdateSender;

// blueprint for a building, shows as light blue outline on screen
public class Blueprint implements MapUpdateSender, MapInfoQuerier {
	private int x;
	private int y;
	private Recipe recipe;
	
	// may be used later to draw the light blue overlay on screen;
	private Actor actor;
	
	private MapUpdateReceiver receiver;
	private MapInfoProvider provider;
	
	public Blueprint(Recipe recipe, int x, int y) {
		this.recipe = recipe;
		this.x = x;
		this.y = y;
	}
	
	public boolean canBuild(Item item) {
		return recipe.canBuild(item);
	}
	
	public boolean overlaps(int x, int y) {
		return recipe.overlaps(this.x, this.y, x, y);
	}
	
	public boolean isValid() {
		recipe.setProvider(getMapInfoProvider());
		recipe.setReceiver(getMapUpdateReceiver());
		return recipe.matches(x, y);
	}
	
	public Building build() {
		recipe.setProvider(getMapInfoProvider());
		recipe.setReceiver(getMapUpdateReceiver());
		return recipe.build(x, y);
	}
	
	public Actor getActor() {
		return actor;
	}

	@Override
	public void setProvider(MapInfoProvider provider) {
		this.provider = provider;
		
	}

	@Override
	public MapInfoProvider getMapInfoProvider() {
		return provider;
	}

	@Override
	public void setReceiver(MapUpdateReceiver receiver) {
		this.receiver = receiver;
	}

	@Override
	public MapUpdateReceiver getMapUpdateReceiver() {
		return receiver;
	}
}
