package hackalot.game.observer;

/**
 * A KeyDownObserver is something that receives messages when a Key is pressed.
 * @author ethan
 *
 */
public interface KeyObserver {


	/**
	 * Called to signify that the Key with keyCode has been pressed down.
	 * @param keyCode The code of the pressed key.
	 */
	abstract public void keyDown(int keyCode);
	
	/**
	 * Called to signify that the Key with keyCode has been released.
	 * @param keyCode The code of the released key.
	 */
	abstract public void keyUp(int keyCode);

}
