package game.Environments;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Actions.PlayerActions.ActivateLostGraceAction;
import game.Actions.PlayerActions.RestAction;
import game.Actions.PlayerActions.TravelAction;
import game.Enums.PlayerStatus;
import game.Interfaces.Teleportable;
import game.Utils.SiteOfLostGraceManager;

/**
 * A class the represents The First Step which is the first site of lost grace.
 * @author Keith Ong Guo Er
 * @version 1.0
 * @see Location
 * @see RestAction
 */
public class SiteOfLostGrace extends Ground implements Teleportable {
    private Boolean activated = false;
    private final GameMap gameMap;
    private final int teleportX;
    private final int teleportY;
    private final String name;


    /**
     * Constructor for TheFirstStep class.
     */
    public SiteOfLostGrace(GameMap map, int x, int y, String name) {
        super('U');
        this.gameMap = map;
        this.teleportX = x;
        this.teleportY = y;
        this.name = name;
        SiteOfLostGraceManager.getInstance().registerSiteOfLostGrace(this);
    }

    /**
     * List of allowable actions that can be done by actor at this location.
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return a list of actions that are able to be performed by actor.
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        if (actor.hasCapability(PlayerStatus.RESTING)){
            if (!this.activated){
                actions.add(new ActivateLostGraceAction(this));
            } else {
                actions.add(new RestAction(this));
                actions.add(SiteOfLostGraceManager.getInstance().teleport(name));
            }
        }

        return actions;
    }

    public void activate() {
        this.activated = true;
    }

    public boolean isActivated(){
        return activated;
    }

    @Override
    public int getTeleportX() {
        return teleportX;
    }

    @Override
    public int getTeleportY() {
        return teleportY;
    }

    @Override
    public GameMap getGameMap() {
        return gameMap;
    }

    public String getName() {
        return name;
    }


}
