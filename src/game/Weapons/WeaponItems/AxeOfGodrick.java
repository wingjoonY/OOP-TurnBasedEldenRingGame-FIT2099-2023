package game.Weapons.WeaponItems;

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
 * Description: Axe of Godrick
 *  - A greataxe wielded by Godrick the Grafted that deals 142 damage with an 84% hit rate
 *
 */

public class AxeOfGodrick extends WeaponItem implements Sellable, Exchangeable {

    /**
     * The price that AxeOfGodrick sells for
     */

    protected final int sellPrice = 100;

    /**
     * The item that can be exchanged to recieve AxeOfGodrick
     */

    protected Item exchangableItem = new RemembranceOfTheGrafted();

    /**
     * Constructor for AxeOfGodrick class.
     */

    public AxeOfGodrick(){
        super("Axe of Godrick",'T',142,"strikes",84);
    }

    /**
     * Method for selling AxeOfGodrick
     *
     * @param actor the actor seling AxeOfGodrick
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
     * Method for exchanging AxeOfGodrick with Remembrance of the Grafted
     *
     * @param actor the actor exchanging Remembrance of the Grafted with AxeOfGodrick
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
     * Getter method for the item to be exchanged with for AxeOfGodrick
     */

    @Override
    public Item exchangableItem() {
        return this.exchangableItem;
    }
}


