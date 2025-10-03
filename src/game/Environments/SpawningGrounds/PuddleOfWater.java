package game.Environments.SpawningGrounds;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.NonPlayableActor.NonPlayableActor;
import game.Utils.EnemyFactory;

/**
 * A class that represents the Puddle Of Water environment.
 * @author Keith Ong Guo Er
 * @version 1.0
 * @see NonPlayableActor
 * @see EnemyFactory
 */
public class PuddleOfWater extends SpawningGrounds {
    /**
     * Constructor for PuddleOfWater class
     */
    public PuddleOfWater() {
        super('~');
    }

}