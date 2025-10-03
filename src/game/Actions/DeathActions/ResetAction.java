package game.Actions.DeathActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Utils.ResetManager;

/**
 * Reset the game
 * @author Sam Zachary Chee Hao Yuan
 * @version 1.0
 * @see Action
 */
public class ResetAction extends Action {

    /**
     * Reset the game when executed
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return A string
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        ResetManager.getInstance().run(map);
        return menuDescription(actor);
    }

    /**
     * Menu description for the action
     * @param actor The actor performing the action.
     * @return A string
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " rests at a Site of Grace";
    }
}
