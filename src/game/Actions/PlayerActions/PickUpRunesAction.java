package game.Actions.PlayerActions;


import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.PickUpAction;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Items.Runes;
import game.Utils.RunesManager;

/**
 * PickUpRunesAction class
 * @author Sam Zachary Chee Hao Yuan
 * @version 1.0
 * @see Action
 */
public class PickUpRunesAction extends PickUpAction {
    Runes runesOnTheGround;

    /**
     * Constructor
     * @param runesOnTheGround Runes on the ground
     */
    public PickUpRunesAction(Runes runesOnTheGround){
        super(runesOnTheGround);
        this.runesOnTheGround = runesOnTheGround;
    }

    /**
     * Executes when the player pick up runes
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return A string
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        RunesManager.getInstance().getRune(actor).setAmount(runesOnTheGround.getAmount() + RunesManager.getInstance().getRune(actor).getAmount());
        return menuDescription(actor);
    }

    /**
     * Menu description for the action
     * @param actor The actor performing the action.
     * @return A string
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " pick up Runes (value:" + runesOnTheGround.getAmount() + ")";
    }




}
