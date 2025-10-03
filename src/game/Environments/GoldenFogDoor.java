package game.Environments;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Actions.PlayerActions.TravelAction;
import game.Enums.PlayerStatus;
import game.Interfaces.Teleportable;

/**
 * ClassSelectAction class
 * @author Sam Zachary Chee Hao Yuan
 * @version 1.0
 * @see Action
 */
public class GoldenFogDoor extends Ground implements Teleportable {
    private final GameMap gameMap;
    private final int teleportX;
    private final int teleportY;
    private final String name;
    /**
     * Constructor.
     */
    public GoldenFogDoor(GameMap map, int x, int y, String name) {
        super('D');
        this.gameMap = map;
        this.teleportX = x;
        this.teleportY = y;
        this.name = name;
    }

    /**
     *
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        if (actor.hasCapability(PlayerStatus.TRAVEL)){
            actions.add(new TravelAction(this));
        }
        return actions;
    }

    public int getTeleportX() {
        return teleportX;
    }

    public int getTeleportY() {
        return teleportY;
    }

    public GameMap getGameMap() {
        return gameMap;
    }

    public String getName() {
        return name;
    }
}
