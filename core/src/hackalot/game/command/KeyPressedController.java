package hackalot.game.command;

import hackalot.game.observer.KeyObservable;
import hackalot.game.observer.KeyObserver;

/**
 * The KeyPressed command activates a subCommand when a KeyObservable tells it keys are pressed and released.
 * @author ethan
 *
 */
public class KeyPressedController implements Controller, KeyObserver {
	
	private KeyObservable observable;
	private int keyCode;
	private Controller subCommand;
	
	/**
	 * Constructs a new KeyPressedCommand.
	 * @param observable The KeyObservable to get updates about key actions from.
	 * @param keyCode The keyCode to track.
	 * @param subCommand The subCommand to activate while the key is Down.
	 */
	public KeyPressedController(KeyObservable observable, int keyCode, Controller subCommand) {
		this.observable = observable;
		this.keyCode = keyCode;
		this.subCommand = subCommand;
	}

	/**
	 * Activates this KeyPressedCommand. While active, it will observe the KeyObservable and activate its Command while
	 * the key with keyCode is pressed.
	 */
	@Override
	public void activate() {
		observable.addObserver(this);
	}

	/**
	 * Deactivates this KeyPressedCommand. While deactive, its Command will never be active.
	 */
	@Override
	public void deactivate() {
		observable.removeObserver(this);
		subCommand.deactivate();
	}
	
	/**
	 * Called to signify that the Key with keyCode has been pressed down. If the keyCode matches, the Command will be activated.
	 * @param keyCode The code of the pressed key.
	 */
	@Override
	public void keyDown(int keyCode) {
		if(keyCode == this.keyCode) subCommand.activate();
	}
	
	/**
	 * Called to signify that the Key with keyCode has been released. If the keyCode matches, the Command will be deactivated.
	 * @param keyCode The code of the released.
	 */
	@Override
	public void keyUp(int keyCode) {
		if(keyCode == this.keyCode) subCommand.deactivate();
	}

}
