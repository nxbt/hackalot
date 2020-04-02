package hackalot.game.entity;

public interface EntityUpdateSender {
    EntityUpdateReceiver getEntityUpdateReceiver();
    void setReceiver( EntityUpdateReceiver receiver);
}
