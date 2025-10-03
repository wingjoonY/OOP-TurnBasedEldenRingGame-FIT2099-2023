package game.Weapons.WeaponItems;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Actions.CombatActions.AOEAttackAction;
import game.Items.Runes;
import game.Utils.RunesManager;
import game.Interfaces.Purchasable;
import game.Interfaces.Sellable;

/**
 * Created by:
 * @author Yap Wing Joon
 * @version 1.0
 * @see WeaponItem
 *
 * Description: Schimitar
 *  - A curved sword with a single-sided blade that deals 118 damage with an 88% hit rate.
 *
 */

public class Scimitar extends WeaponItem implements Purchasable, Sellable {

    protected final int buyPrice = 600;
    protected final int sellPrice = 100;

    /**
     * Constructor for Scimitar class
     */

    public Scimitar(){
        super("Scimitar", 's', 118, "slashes", 88);
    }

    /**
     * Method for purchasing Scimitar
     *
     * @param actor the actor purchasing Scimitar
     *
     */

    @Override
    public String purchase(Actor actor) {
        Runes runes = RunesManager.getInstance().getRune(actor);
        int runesAmount = runes.getAmount();
        if (runesAmount >= buyPrice){
            actor.addWeaponToInventory(this);
            runesAmount -= buyPrice;
            return actor + " purchased an " + this + " for " + this.buyPrice;
        } else {
            return (buyPrice - runesAmount) + " more runes needed to purchase " + this;
        }

    }

    /**
     * Method for selling Scimitar
     *
     * @param actor the actor seling Scimitar
     *
     */

    @Override
    public String sell(Actor actor) {
        for (WeaponItem weaponItem : actor.getWeaponInventory()){
            if (weaponItem.toString().equals(this.toString())) {
                Runes runes = RunesManager.getInstance().getRune(actor);
                int runesAmount = runes.getAmount();
                actor.removeWeaponFromInventory(weaponItem);
                runesAmount += sellPrice;
                return actor + " sold " + this + " to obtain " + this.sellPrice + " runes.";
            }
        }
        return this + " does not exist in player's inventory";

    }

    /**
     * Get the skill action from Scimitar. Use this method if you want to use a AOEAttackAction.
     * @param target target actor
     * @param direction
     * @return
     */
    @Override
    public Action getSkill(Actor target, String direction) {
        return new AOEAttackAction(target, direction,this);
    }
}


