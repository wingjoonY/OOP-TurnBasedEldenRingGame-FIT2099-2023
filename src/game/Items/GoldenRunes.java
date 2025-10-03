package game.Items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.Actions.PlayerActions.ConsumeAction;
import game.Interfaces.Consumable;
import game.Interfaces.Purchasable;
import game.Interfaces.Resettable;
import game.Interfaces.Sellable;
import game.Utils.RandomNumberGenerator;
import game.Utils.ResetManager;
import game.Utils.RunesManager;

/**
 * A golden runes class that spawns randomly on dirt and removed when game is reset
 *
 * @author Sam Zachary Chee Hao Yuan
 * @version 1.0
 * @see Item
 * @see Consumable
 * @see Resettable
 */
public class GoldenRunes extends Item implements Consumable, Resettable {
    private int useCount = 1;
    Location currentLocation;
    /***
     * Constructor.
     */
    public GoldenRunes(Location currentLocation) {
        super("Golden Runes", '*', true);
        this.addAction(new ConsumeAction(this));
        this.currentLocation = currentLocation;
        ResetManager.getInstance().registerResettable(this);
    }

    /**
     * Increases player's runes when consumed
     * @param actor the actor consuming this
     * @return A string
     */
    @Override
    public String consume(Actor actor) {
        Runes runes =  RunesManager.getInstance().getRune(actor);
        int randomRunesAmount = RandomNumberGenerator.getRandomInt(200, 10000);
        runes.setAmount(runes.getAmount() + randomRunesAmount);
        actor.removeItemFromInventory(this);
        return actor + " consumes Golden Runes to get " + randomRunesAmount;
    }

    /**
     * Gets the number of times the golden runes can be consumed.
     *
     * @return The number of times the golden runes can be consumed.
     */
    @Override
    public int getUseCount() {
        return useCount;
    }

    /**
     * Remove golden seed from the map
     * @param map the game map
     */
    @Override
    public void reset(GameMap map) {
        if (currentLocation != null) {
            currentLocation.removeItem(this);
        }
    }
}
