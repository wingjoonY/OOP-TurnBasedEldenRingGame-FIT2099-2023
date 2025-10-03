package game.Actions.PlayerActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Environments.SiteOfLostGrace;
import game.Items.Runes;
import game.Utils.ResetManager;
import game.Utils.RunesManager;

/**
 * RestAction class for when the player rests at a site of grace
 * @author Sam Zachary Chee Hao Yuan
 * @version 1.0
 * @see Action
 */
public class RestAction extends Action {
    private SiteOfLostGrace siteOfLostGrace;

    /**
     * Constructor
     * @param siteOfLostGrace
     */
    public RestAction(SiteOfLostGrace siteOfLostGrace){
        this.siteOfLostGrace = siteOfLostGrace;
    }

    /**
     * Executes when the player rest at a site of grace (Partially resets the map)
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return A string
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        ResetManager.getInstance().playerRest(map);
        return menuDescription(actor);
    }

    /**
     * Menu description for the action
     * @param actor The actor performing the action.
     * @return A string
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " rests at " + siteOfLostGrace.getName();
    }
}
