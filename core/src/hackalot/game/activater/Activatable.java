package hackalot.game.activater;

public interface Activatable {
	
	default public void addActivater(Activater activater) {
		activater.addActivatable(this);
	}
	
	default public void removeActivater(Activater activater) {
		activater.removeActivatable(this);
	}
	
	abstract public void activate();
	abstract public void deactivate();

}
