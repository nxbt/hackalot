package hackalot.game.command;

import hackalot.game.entity.Character;

public class ChangeItemController implements Controller {
	
	private Character character;
	
	public ChangeItemController(Character character) {
		this.character = character;
	}

	@Override
	public void activate() {
		character.changeItem();
	}

	@Override
	public void deactivate() {
	}

}
