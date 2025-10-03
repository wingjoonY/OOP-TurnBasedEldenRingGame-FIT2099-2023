package game.Actions.PlayerActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.PlayableArchetypes.PlayableCharacter;

/**
 * ClassSelectAction class for SummonAction class (More like a Util class)
 * @author Sam Zachary Chee Hao Yuan
 * @version 1.0
 * @see Action
 */
public class ClassSelectAction extends Action {
    PlayableCharacter roles;

    /**
     * Constructor
     * @param roles the role chosen for the summons
     */
    public ClassSelectAction(PlayableCharacter roles) {
        this.roles = roles;
    }

    /**
     * Activate site of lost grace when executed
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return A string
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        actor.resetMaxHp(roles.getHp());
        actor.addWeaponToInventory(roles.getWeapon());
        return actor + " is a " + roles;
    }

    /**
     * Menu description for the action
     * @param actor The actor performing the action.
     * @return A string
     */
    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
