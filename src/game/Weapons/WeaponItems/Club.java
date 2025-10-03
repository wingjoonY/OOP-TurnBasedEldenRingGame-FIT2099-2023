package game.Weapons.WeaponItems;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Items.Runes;
import game.Utils.RunesManager;
import game.Interfaces.Purchasable;
import game.Interfaces.Sellable;

/**
 *
 * Created by:
 * @author Adrian Kristanto
 * @version
 * Modified by:
 * @author Yap Wing Joon
 * @see WeaponItem
 *
 * Description: Club
 * - A thick, solid lump of wood that deals 103 damage with an 80% hit rate.
 *
 */


public class Club extends WeaponItem implements Purchasable, Sellable {

    /**
     * The price that Club buys and sells for
     */

    protected final int buyPrice = 600;
    protected final int sellPrice = 100;

    /**
     * Constructor for Club class.
     */
    public Club() {
        super("Club", '!', 103, "bonks", 80);
    }

    /**
     * Method for purchasing Club
     *
     * @param actor the actor seling Club
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
     * Method for selling Club
     *
     * @param actor the actor seling Club
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
