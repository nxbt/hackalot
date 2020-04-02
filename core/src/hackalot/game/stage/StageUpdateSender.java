package hackalot.game.stage;

public interface StageUpdateSender {
	
	
	/**
	 * Sets the receiver to an input receiver
	 * @param receiver
	 */
	public void setReceiver(StageUpdateReceiver receiver);
	
	/**
	 * Getter for the receiver 
	 * @return
	 */
	public StageUpdateReceiver getStageUpdateReceiver();
	
}
