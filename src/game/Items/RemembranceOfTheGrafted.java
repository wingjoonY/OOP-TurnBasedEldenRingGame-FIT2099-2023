package game.Items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.Interfaces.Consumable;
import game.Interfaces.Resettable;
import game.Interfaces.Sellable;
import game.Utils.RunesManager;

/**
 * The item dropped after defeating Godrick the Grafted which can be exhchanged for AxeOfGodrick and GraftedDragon
 * by FingerReaderEnia
 *
 * @author Yap Wing Joon
 * @version 1.0
 * @see Item
 * @see Sellable
 */

public class RemembranceOfTheGrafted extends Item implements Sellable {

    /**
     * The price RemembranceOfTheGrafted sells for
     */

    protected final int sellPrice = 20000;

    /**
     * Constructor for Remembrance of the Grafted.
     */

    public RemembranceOfTheGrafted() {
        super("Remembrance of the Grafted", '0', true);
    }

    /**
     * Method for selling RemembranceOfTheGrafted
     *
     * @param actor the actor seling RemembranceOfTheGrafted
     *
     */

    public String sell(Actor actor) {

        for (Item item : actor.getItemInventory()) {
            if (item.toString().equals(this)) {
                Runes runes = RunesManager.getInstance().getRune(actor);
                int runesAmount = runes.getAmount();
                actor.removeItemFromInventory(this);
                runesAmount += sellPrice;
                return actor + " sold " + this + " to obtain " + this.sellPrice + " runes.";

            }
        }
        return this + " does not exist in player's inventory";

    }


}
