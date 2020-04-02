package hackalot.game.entity;

public interface EntityUpdateSender {
    void setReceiver(EntityUpdateReceiver receiver);
    EntityUpdateReceiver getReceiver();
}
