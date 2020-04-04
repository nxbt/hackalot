package hackalot.game.observer;

/**
 * A KeyDownObserver is something that receives messages when a Key is pressed.
 * @author ethan
 *
 */
public interface KeyObserver {
	
	abstract public void keyDown(int keyCode);
	abstract public void keyUp(int keyCode);

}
