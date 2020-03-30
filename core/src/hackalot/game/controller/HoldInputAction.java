package hackalot.game.controller;

public class HoldInputAction extends InputAction {
	@Override
	public void risingEdge() {
		active = true;
	}

	@Override
	public void fallingEdge() {
		active = false;
	}

	@Override
	protected void afterTick() {

	}
}
