package game.Items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Actions.PlayerActions.ConsumeAction;
import game.Interfaces.Consumable;
import game.Utils.ResetManager;
import game.Interfaces.Resettable;

/**
 * A Singleton class of Flask of Crimson Tears
 *
 * @author Sam Zachary Chee Hao Yuan
 * @version 1.0
 * @see Item
 * @see Resettable
 * @see Consumable
 */
public class FlaskOfCrimsonTears extends Item implements Resettable, Consumable {
    /**
     * The number of times the Flask of Crimson Tears can be consumed.
     */
    private int useCount = 2;

    /**
     * The amount of heal bestowed by Flask of Crimson Tears
     */
    private int healAmount = 250;

    /**
     * Since there is only one player on the map, there should only be one Flask of Crimson Tears
     */
    private static FlaskOfCrimsonTears instance = null;

    /***
     * Constructor.
     */
    private FlaskOfCrimsonTears() {
        super("Flask of Crimson Tears", 'c', true);
        this.addAction(new ConsumeAction(this));
        ResetManager.getInstance().registerResettable(this);

    }

    /**
     * Increases player's health when consumed
     * @param actor the actor consuming this
     * @return A string
     */
    @Override
    public String consume(Actor actor) {
        if (useCount < 1){
            return "Item out of uses";
        } else {
            useCount -= 1;
            actor.heal(healAmount);
            return actor + " consumes Flask of Crimson Tears to heal " + healAmount + "." ;
        }
    }

    @Override
    public int getUseCount() {
        return useCount;
    }

    public void incrementUseCount(int amount) {
        this.useCount += amount;
    }

    /**
     * Reset Flask of Crimson Tears
     */
    @Override
    public void reset(GameMap map) {
        useCount = 2;
    }

    /**
     * Gets and instance of Flask of Crimson Tears class
     * @return the instance of Flask of Crimson Tears class
     */
    public static FlaskOfCrimsonTears getInstance() {
        if (instance == null) {
            instance = new FlaskOfCrimsonTears();
        }
        return instance;
    }


}
