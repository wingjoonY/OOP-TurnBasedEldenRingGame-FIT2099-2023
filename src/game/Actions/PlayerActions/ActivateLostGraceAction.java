package game.Actions.PlayerActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Environments.SiteOfLostGrace;

/**
 * ActivateLostGraceAction class for activating site of lost graces
 * @author Sam Zachary Chee Hao Yuan
 * @version 1.0
 * @see Action
 */
public class ActivateLostGraceAction extends Action {
    private final SiteOfLostGrace siteOfLostGrace;

    public ActivateLostGraceAction(SiteOfLostGrace siteOfLostGrace){
        this.siteOfLostGrace = siteOfLostGrace;
    }

    /**
     * Activate site of lost grace when executed
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return A string
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        siteOfLostGrace.activate();
        return actor + " activated " + siteOfLostGrace.getName();
    }

    /**
     * Menu description for the action
     * @param actor The actor performing the action.
     * @return A string
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " activates " + siteOfLostGrace.getName();
    }
}
