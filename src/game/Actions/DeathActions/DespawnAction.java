package game.Actions.DeathActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
/**
 *  An action to de-spawn an actor
 * @author Keith Ong Guo Er
 * @version 1.0
 * @see Action
 */
public class DespawnAction extends Action {

    /**
     * When executed, an actor will de-spawn from the game map.
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return menuDescription which is the description used for the menu UI.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        map.removeActor(actor);
        return menuDescription(actor);
    }

    /**
     * Menu description for the action
     * @param actor The actor performing the action.
     * @return A string
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " is removed from the Lands Between";
    }
}
