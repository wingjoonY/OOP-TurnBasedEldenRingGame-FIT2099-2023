package game.Behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Actions.DeathActions.DespawnAction;
import game.Interfaces.Behaviour;
import game.Utils.RandomNumberGenerator;

/**
 * A class that uses DespawnAction to allow actors to De-spawn.
 * @author Keith Ong Guo Er
 * @version 1.0
 * @see DespawnAction
 */

public class DespawnBehaviour implements Behaviour {
    private final int chanceToDespawn = 10;

    /**
     * A method that gets DespawnAction
     * De-spawns the actor when random number generated is lesser or equal to its chance.
     * @param actor the Actor acting
     * @param map the GameMap containing the Actor
     * @return DespawnAction
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        if (RandomNumberGenerator.getRandomInt(100) <= chanceToDespawn){
            return new DespawnAction();
        } else {
            return null;
        }
    }
}
