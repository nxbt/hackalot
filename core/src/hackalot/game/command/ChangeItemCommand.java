package hackalot.game.command;

import hackalot.game.entity.Character;

public class ChangeItemCommand implements Command {
	
	private Character character;
	
	public ChangeItemCommand(Character character) {
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
