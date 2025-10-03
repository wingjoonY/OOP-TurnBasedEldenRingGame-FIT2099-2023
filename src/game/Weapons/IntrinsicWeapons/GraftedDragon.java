package game.Weapons.IntrinsicWeapons;


import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Interfaces.Exchangeable;
import game.Interfaces.Sellable;
import game.Items.RemembranceOfTheGrafted;
import game.Items.Runes;
import game.Utils.RunesManager;

/**
 *
 * @author Yap Wing Joon
 * @version 1.0
 * @see WeaponItem
 * @see Sellable
 * @see Exchangeable
 *
 * Description: Grafted Dragon
 *  - A fist in the form of a dragon head that was grafted to Godrick's left arm that deals 89 damage with a 90% hit rate
 *
 */


public class GraftedDragon extends WeaponItem implements Sellable, Exchangeable {

    /**
     * The price that GraftedDragon sells for
     */

    protected final int sellPrice = 200;

    /**
     * The item that can be exchanged to recieve GraftedDragon
     */
    protected Item exchangableItem = new RemembranceOfTheGrafted();

    public GraftedDragon(){
        super("Grafted Dragon",'N',89,"strikes",90);
    }

    /**
     * Method for selling GraftedDragon
     *
     * @param actor the actor seling GraftedDragon
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
     * Method for exchanging GraftedDragon with Remembrance of the Grafted
     *
     * @param actor the actor exchanging Remembrance of the Grafted with GraftedDragon
     *
     */

    @Override
    public String exchange(Actor actor) {
        for (Item item: actor.getItemInventory()){
            if(item.toString().equals(exchangableItem.toString())){
                actor.addWeaponToInventory(this);
                actor.removeItemFromInventory(item);
                return actor + " exchanged " + item + " for " + this;
            }
        }
        return exchangableItem.toString() + " does not exist in player's inventory";
    }

    /**
     * Getter method for the item to be exchanged with for GraftedDragon
     */

    @Override
    public Item exchangableItem() {
        return this.exchangableItem;
    }
}
