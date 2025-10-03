package game.Weapons.WeaponItems;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.*;
import game.Actions.CombatActions.QuickstepAction;
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
 * Description: Great Knife
 *  - A large dagger with a broad, curved blade that deals 75 damage with a 70% hit rate.
 *
 */

public class GreatKnife extends WeaponItem implements Purchasable, Sellable {

    protected final int buyPrice = 3500;
    protected final int sellPrice = 350;

    /**
     * Constructor for GreatKnife class.
     */

    public GreatKnife() {
        super("Great Knife",'/',75,"stabs",70);
    }


    /**
     * Constructor for GreatKnife class.
     *
     * @param name        name of the item
     * @param displayChar character to use for display when item is on the ground
     * @param damage      amount of damage this weapon does
     * @param verb        verb to use for this weapon, e.g. "hits", "zaps"
     * @param hitRate     the probability/chance to hit the target.
     *
     */

    public GreatKnife(String name, char displayChar, int damage, String verb, int hitRate){
        super(name, displayChar, damage, verb, hitRate);
    }

    /**
     * Method for purchasing GreatKnife
     *
     * @param actor the actor purchasing GreatKnife
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
     * Method for selling GreatKnife
     *
     * @param actor the actor seling GreatKnife
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
     * Get the skill action from Uchigatana. Use this method if you want to use an UnsheatheAction
     * against one targeted Actor
     * @param target the target actor
     * @param direction the direction of target, e.g. "north"
     * @return returns an UnsheatheAction
     */

    @Override
    public Action getSkill(Actor target, String direction) {
        return new QuickstepAction(target,direction,this);
    }
}
