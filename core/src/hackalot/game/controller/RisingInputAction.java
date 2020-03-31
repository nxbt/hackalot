package hackalot.game.controller;

public class RisingInputAction extends InputAction {
	@Override
	public void risingEdge() {
		active = true;
	}

	@Override
	public void fallingEdge() {

	}

	@Override
	protected void afterTick() {
		active = false;
	}
}
