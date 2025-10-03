package game.Actions.DeathActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Items.Runes;
import game.Enums.PlayerStatus;
import game.Utils.RunesManager;

/**
 * An action executed if an actor is killed.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 * Yap Wing Joon
 */
public class DeathAction extends Action {


    private Actor attacker;

    public DeathAction(Actor actor) {
        this.attacker = actor;
    }

    /**
     * When the target is killed, the items & weapons carried by target
     * will be dropped to the location in the game map where the target was
     *
     * @param target The actor performing the action.
     * @param map The map the actor is on.
     * @return result of the action to be displayed on the UI
     */
    @Override
    public String execute(Actor target, GameMap map) {
        String result = "";

        ActionList dropActions = new ActionList();
        if (attacker.hasCapability(PlayerStatus.HOSTILE_TO_ENEMY)){
            for (WeaponItem weapon : target.getWeaponInventory()) {
                dropActions.add(weapon.getDropAction(target));
            }
            Runes runesEnemy = RunesManager.getInstance().getRune(target);
            Runes runesPlayer = RunesManager.getInstance().getRune(attacker);
            int runesAmount = runesPlayer.getAmount() + runesEnemy.getAmount();
            runesPlayer.setAmount(runesAmount);
        }
        // drop all items
        for (Item item : target.getItemInventory())
            dropActions.add(item.getDropAction(target));
        for (WeaponItem weapon : target.getWeaponInventory())
            dropActions.add(weapon.getDropAction(target));
        for (Action drop : dropActions)
            drop.execute(target, map);
        // remove actor
        map.removeActor(target);
        result += System.lineSeparator() + menuDescription(target);
        return result;
    }

    /**
     * Describes the actor's death
     *
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */

    @Override
    public String menuDescription(Actor actor) {
        return actor + " is killed.";
    }
}
