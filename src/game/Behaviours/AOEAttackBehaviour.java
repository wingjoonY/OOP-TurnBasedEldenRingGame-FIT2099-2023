package game.Behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.Actions.CombatActions.AOEAttackAction;
import game.Enums.NonPlayableType;
import game.Enums.PlayerStatus;
import game.Interfaces.Behaviour;
import game.Utils.RandomNumberGenerator;
/**
 * Created by:
 * @author Yap Wing Joon
 * Modified by:
 *
 */
public class AOEAttackBehaviour implements Behaviour {

    @Override
    public Action getAction(Actor actor, GameMap map) {
        Location here = map.locationOf(actor);
        NonPlayableType nonPlayableType = (NonPlayableType) actor.capabilitiesList().stream().filter(NonPlayableType::matchEnum).toArray()[0];
        for (Exit exit : here.getExits()) {
            Location destination = exit.getDestination();
            if (destination.containsAnActor()) {
                Actor target = destination.getActor();
                if (nonPlayableType == NonPlayableType.ALLY){
                    if (target.hasCapability(PlayerStatus.HOSTILE_TO_ENEMY)){
                        continue;
                    }
                }
                if (!target.hasCapability(nonPlayableType)) {
                    if (RandomNumberGenerator.getRandomInt(100) >= 50) {
                        return new AOEAttackAction(target, exit.getName(), actor.getWeaponInventory().get(0));
                    } else {
                        return null;
                    }
                }
            }

        }
        return null;
    }
}