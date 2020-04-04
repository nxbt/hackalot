package hackalot.game.activater;

public interface Activater {
	
	/**
	 * Never Call!
	 * @param activater
	 */
	abstract public void addActivatable(Activatable activatable);

	/**
	 * Never Call!
	 * @param activater
	 */
	abstract public void removeActivatable(Activatable activatable);

}
