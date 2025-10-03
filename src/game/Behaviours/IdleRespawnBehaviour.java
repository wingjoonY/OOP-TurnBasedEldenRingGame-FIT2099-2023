package game.Behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Interfaces.Behaviour;
import game.Interfaces.Respawnable;


/**
 * A class to describe idle action for actor Pile Of Bones when respawning
 * @author Keith Ong Guo Er
 * @version 1.0
 * @see game.Interfaces.Behaviour
 * @see Respawnable
 */
public class IdleRespawnBehaviour implements Behaviour {

    /**
     * A respawnable used to describe actors that can respawn
     */
    Respawnable respawnable;

    /**
     * A constructor for the IdleRespawnBehaviour class
     * @param respawnable Type used to describe actors that are able to respawn
     */
    public IdleRespawnBehaviour(Respawnable respawnable){
        this.respawnable = respawnable;
    }

    /**
     * A method that allows actor a chance to respawn by checking if its number of turns left to respawn
     * @param actor the Actor acting
     * @param map the GameMap containing the Actor
     * @return respawned actor
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        if (respawnable.getTurnsToRespawn() >  0){
            respawnable.countDown();
            return null;
        } else {
            return respawnable.respawn();
        }
    }
}
