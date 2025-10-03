package game.Behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Interfaces.Behaviour;

/**
 * A class that describes idle or no action is done behaviour for actors
 * @author Keith Ong Guo Er
 * @version 1.0
 * @see Behaviour
 */
public class IdleBehaviour implements Behaviour {
    @Override
    public Action getAction(Actor actor, GameMap map) {
        return null;
    }
}
