package hackalot.game.entity;

public interface EntityUpdateReceiver {
    void spawn(Entity entity);
    void despawn(Entity entity);
}
