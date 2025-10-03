package game.Actions.PlayerActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.PlayableArchetypes.*;
import game.NonPlayableActor.Summons.Ally;
import game.NonPlayableActor.Summons.Invader;
import game.NonPlayableActor.Summons.Summons;
import game.Utils.RandomNumberGenerator;

/**
 * SummonAction class used to summon Ally or Invader
 * @author Sam Zachary Chee Hao Yuan
 * @version 1.0
 * @see Action
 */
public class SummonAction extends Action {

    /**
     * Executes when the player summons
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return A string
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        Summons[] summonsArray = new Summons[]{new Ally(), new Invader(actor)};
        int randintSummons = RandomNumberGenerator.getRandomInt(2);
        Summons summons = summonsArray[randintSummons];
        PlayableCharacter[] rolesArray = new PlayableCharacter[]{new Samurai(), new Bandit(), new Wretch(), new Astrologer()};
        int randintRoles = RandomNumberGenerator.getRandomInt(4);
        PlayableCharacter roles = rolesArray[randintRoles];
        new ClassSelectAction(roles).execute(summons, map);
        Location playerLocation = map.locationOf(actor);
        for (Exit exit : playerLocation.getExits()) {
            if (!exit.getDestination().containsAnActor() && exit.getDestination().canActorEnter(summons)) {
                map.addActor(summons, exit.getDestination());
                return summons + " has been summoned as a " + roles;
            }
        }
        return "No valid spaces to summon";
    }

    /**
     * Menu description for the action
     * @param actor The actor performing the action.
     * @return A string
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " summons another entity";
    }
}

