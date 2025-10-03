package game.Actions.TradeActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Interfaces.Exchangeable;

/**
 * ExchangeAction class is a class that describes the act of exchanging an item for another.
 * @author Yap Wing Joon
 * @version 1.0
 * @see Exchangeable
 * @see Action
 */
public class ExchangeAction extends Action {

    /**
     * Items/ weapons that are exchangeable.
     */

    Exchangeable exchangeable;

    /**
     * Constructor for the ExchangeAction Class.
     * @param exchangeable items/ weapons that are exchangeable.
     */
    public ExchangeAction(Exchangeable exchangeable){
        this.exchangeable = exchangeable;
    }

    /**
     * When executed, actor exchanges an item with another item/ weapon.
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return the result of type string which displays whichever weapon is purchased.
     */

    @Override
    public String execute(Actor actor, GameMap map) {
        String result = exchangeable.exchange(actor);
        return result;
    }

    /**
     * Menu description for the action
     * @param actor The actor performing the action.
     * @return A string
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " exchanges " + exchangeable.exchangableItem().toString() + " for " + exchangeable;
    }
}
