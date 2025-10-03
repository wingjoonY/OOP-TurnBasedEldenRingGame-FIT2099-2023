package game.Environments.SpawningGrounds;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.NonPlayableActor.NonPlayableActor;
import game.Utils.EnemyFactory;

/**
 * A class that represents the graveyard environment.
 * @author Keith Ong Guo Er
 * @version 1.1
 * @see NonPlayableActor
 * @see EnemyFactory
 * @see Location
 *
 */
public class Graveyard extends SpawningGrounds {

    /**
     * Constructor for graveyard class
     */
    public Graveyard() {
        super('n');
    }


}