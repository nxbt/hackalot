package hackalot.game.controller;

/**
 * PlayerController class for controlling player characters
 * @author Brendan
 */
public class PlayerController extends Controller {

	private PlayerInputListener inputListener;

	public PlayerController() {
		super();

		inputListener = new PlayerInputListener( this );

		addInputAction( "interact", new RisingInputAction() );
	}

	public PlayerInputListener getInputListener() {
		return inputListener;
	}

	public void risingInputAction( String name ) {
		inputActionMap.get( name ).risingEdge();
	}

	public void fallingInputAction( String name ) {
		inputActionMap.get( name ).fallingEdge();
	}

	@Override
	public void updateDirection() {
		direction.set( inputListener.getDirection() );
	}

	@Override
	public void updateInputActionMap() {

	}
}
