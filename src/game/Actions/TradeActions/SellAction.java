package game.Actions.TradeActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Interfaces.Sellable;
/**
 * SellAction class is a class that describes the act of selling a weapon.
 * @author Keith Ong Guo Er
 * @version 1.0
 * @see Sellable
 * @see Action
 */
public class SellAction extends Action {

    /**
     * Weapons that can be sold.
     */
    private Sellable sellable;

    /**
     * Constructor for the SellAction class.
     * @param sellable weapons that can be sold.
     */

    public SellAction (Sellable sellable){
        this.sellable = sellable;
    }

    /**
     * When executed, actor sells a weapon.
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return the result of type string which displays whichever weapon is sold.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String result = sellable.sell(actor);
        return result;
    }

    /**
     * Describes which weapon is being sold by the actor.
     * @param actor The actor performing the action.
     * @return a description used for the menu UI.
     */

    @Override
    public String menuDescription(Actor actor) {
        return actor + " sells " + sellable.toString();
    }
}
