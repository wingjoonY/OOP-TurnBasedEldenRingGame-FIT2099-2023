package game.Weapons.WeaponItems;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Interfaces.Purchasable;
import game.Items.Runes;
import game.Utils.RunesManager;
import game.Weapons.RangedWeapon;
import game.Interfaces.Sellable;

/**
 * Created by:
 * @author Sam Zachary Chee Hao Yuan
 * @version 1.0
 * @see RangedWeapon
 *
 * Astrologer's Staff (A ranged weapon)
 *
 */
public class AstrologerStaff extends RangedWeapon implements Sellable, Purchasable {
    protected final int buyPrice = 800;
    protected final int sellPrice = 100;

    /**
     * Constructor.
     */
    public AstrologerStaff() {
        super("Astrologer's Staff", 'f', 274, "shoots", 50, 3);
    }

    /**
     * Method for purchasing Astrologer's Staff
     *
     * @param actor the actor purchasing Astrologer's Staff
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
     * Method for selling Astrologer's Staff
     *
     * @param actor the actor selling Astrologer's Staff
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
}
