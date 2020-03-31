package hackalot.game.controller;

public class FallingInputAction extends InputAction {
	@Override
	public void risingEdge() {

	}

	@Override
	public void fallingEdge() {
		active = true;
	}

	@Override
	protected void afterTick() {
		active = false;
	}
}
