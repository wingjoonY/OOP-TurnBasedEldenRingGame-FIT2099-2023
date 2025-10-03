package game.Actions.PlayerActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.Environments.GoldenFogDoor;
import game.Interfaces.Teleportable;

/**
 * TravelAction class used when the player travels
 * @author Sam Zachary Chee Hao Yuan
 * @version 1.0
 * @see Action
 */
public class TravelAction extends Action {
    private final Teleportable teleportable;

    /**
     * Constructor
     * @param teleportable SiteOfLostGrace or GoldenFogDoor
     */
    public TravelAction(Teleportable teleportable){
        this.teleportable = teleportable;
    }

    /**
     * Executes when the players teleport
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return A string
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        map.moveActor(actor, teleportable.getGameMap().at(teleportable.getTeleportX(), teleportable.getTeleportY()));
        return actor + " teleported to another map";
    }

    /**
     * Menu description for the action
     * @param actor The actor performing the action.
     * @return A string
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " travels to " + teleportable.getName();
    }
}
