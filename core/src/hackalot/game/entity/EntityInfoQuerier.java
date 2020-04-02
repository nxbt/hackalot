package hackalot.game.entity;

public interface EntityInfoQuerier {
    EntityInfoProvider getEntityInfoProvider();
    void setProvider(EntityInfoProvider provider);
}
