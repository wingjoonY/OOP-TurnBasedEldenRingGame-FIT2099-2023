package game.Environments;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Enums.PlayerStatus;

public class Cliff extends Ground {
    /**
     * Constructor.
     */
    public Cliff() {
        super('+');
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        return actor.hasCapability(PlayerStatus.HOSTILE_TO_ENEMY);
    }

    @Override
    public void tick(Location location) {
        if (location.containsAnActor()) {
            Actor actor = location.getActor();
            if (actor.hasCapability(PlayerStatus.HOSTILE_TO_ENEMY)){
                actor.hurt(9999);
            }
        }
    }
}
