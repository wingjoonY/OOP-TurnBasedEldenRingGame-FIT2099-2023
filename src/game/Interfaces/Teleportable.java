package game.Interfaces;

import edu.monash.fit2099.engine.positions.GameMap;

public interface Teleportable {
    public int getTeleportX();

    public int getTeleportY();

    public GameMap getGameMap();

    public String getName();
}
