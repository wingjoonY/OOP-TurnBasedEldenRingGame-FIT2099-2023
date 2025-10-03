package game.Environments.SpawningGrounds;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.NonPlayableActor.NonPlayableActor;
import game.Utils.EnemyFactory;

public abstract class SpawningGrounds extends Ground {
    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public SpawningGrounds(char displayChar) {
        super(displayChar);
    }

    /**
     * Spawn enemies
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        if (!location.containsAnActor()){
            EnemyFactory.getInstance().setGround(this, location);
            NonPlayableActor nonPlayableActor = EnemyFactory.getInstance().spawn();
            if (nonPlayableActor != null) {
                location.addActor(nonPlayableActor);
            }
        }
    }
}
