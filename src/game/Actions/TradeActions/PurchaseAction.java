package game.Actions.TradeActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Interfaces.Purchasable;

/**
 * PurchaseAction class is a class that describes the act of purchasing a weapon.
 * @author Keith Ong Guo Er
 * @version 1.0
 * @see Purchasable
 * @see Action
 */
public class PurchaseAction extends Action {
    /**
     * Weapons that are purchasable.
     */
    private Purchasable purchasable;

    /**
     * Constructor for the PurchaseAction Class.
     * @param purchasable weapons that are purchasable.
     */
    public PurchaseAction(Purchasable purchasable){
        this.purchasable = purchasable;
    }

    /**
     * When executed, actor purchases a weapon.
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return the result of type string which displays whichever weapon is purchased.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String result = purchasable.purchase(actor);
        return result;
    }

    /**
     * Describes which weapon is being purchased by the actor.
     * @param actor The actor performing the action.
     * @return a description used for the menu UI.
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " purchases " + purchasable.toString();
    }
}
