package game.Items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Actions.PlayerActions.ConsumeAction;
import game.Enums.Ailments;
import game.Interfaces.Consumable;
import game.Interfaces.Purchasable;
import game.Interfaces.Sellable;
import game.Utils.RunesManager;

/**
 * A poison boluses that can be consumed to remove poison status.
 *
 * @author Sam Zachary Chee Hao Yuan
 * @version 1.0
 * @see Item
 * @see Consumable
 * @see Sellable
 * @see Purchasable
 */
public class PoisonBoluses extends Item implements Consumable, Sellable, Purchasable {
    /**
     * The number of times the boluses can be consumed.
     */
    int useCount = 1;

    protected final int buyPrice = 500;

    protected final int sellPrice = 50;

    /***
     * Constructor.
     */
    public PoisonBoluses() {
        super("Poison Boluses", '2', true);
        this.addAction(new ConsumeAction(this));
    }

    /**
     * Removes poison status when consumed
     * @param actor the actor consuming this
     * @return A string
     */
    @Override
    public String consume(Actor actor) {
        useCount -= 1;
        if (actor.hasCapability(Ailments.POISONED)) {
            actor.removeCapability(Ailments.POISONED);
        }
        actor.removeItemFromInventory(this);
        return actor + " consumed"  + this;
    }

    @Override
    public int getUseCount() {
        return 0;
    }

    @Override
    public String purchase(Actor actor) {
        Runes runes = RunesManager.getInstance().getRune(actor);
        int runesAmount = runes.getAmount();
        if (runesAmount >= buyPrice){
            actor.addItemToInventory(this);
            runesAmount -= buyPrice;
            return actor + " purchased an " + this + " for " + this.buyPrice;
        } else {
            return (buyPrice - runesAmount) + " more runes needed to purchase " + this;
        }
    }

    @Override
    public String sell(Actor actor) {
        for (Item item : actor.getItemInventory()){
            if (item.toString().equals(this.toString())) {
                Runes runes = RunesManager.getInstance().getRune(actor);
                int runesAmount = runes.getAmount();
                actor.removeItemFromInventory(item);
                runesAmount += sellPrice;
                return actor + " sold " + this + " to obtain " + this.sellPrice + " runes.";
            }
        }
        return this + " does not exist in player's inventory";
    }
}
