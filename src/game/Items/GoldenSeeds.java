package game.Items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.Actions.PlayerActions.ConsumeAction;
import game.Interfaces.Consumable;
import game.Interfaces.Purchasable;
import game.Interfaces.Sellable;
import game.Utils.RunesManager;

/**
 * A golden seed that can be consumed to increase the number of uses on the Flask of Crimson Tears
 *
 * @author Sam Zachary Chee Hao Yuan
 * @version 1.0
 * @see Item
 * @see Consumable
 */
public class GoldenSeeds extends Item implements Consumable, Sellable, Purchasable {
    /**
     * The number of times the golden seed can be consumed.
     */
    int useCount = 1;

    protected final int buyPrice = 1000;

    protected final int sellPrice = 50;

    /**
     * Constructor
     */
    public GoldenSeeds() {
        super("Golden Seeds", '1', true);
        this.addAction(new ConsumeAction(this));
    }

    /**
     * Increases FlaskOfCrimsonTear uses when cosumed
     * @param actor The actor to restore health to.
     * @return A message indicating the result of the consumption.
     */
    @Override
    public String consume(Actor actor) {
        useCount -= 1;
        FlaskOfCrimsonTears.getInstance().incrementUseCount(1);
        actor.removeItemFromInventory(this);
        return actor + " consumed"  + this;
    }


    /**
     * Gets the number of times the golden seed can be consumed.
     *
     * @return The number of times the golden seed can be consumed.
     */
    @Override
    public int getUseCount() {
        return useCount;
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
