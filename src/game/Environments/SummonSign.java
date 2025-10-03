package game.Environments;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Actions.PlayerActions.SummonAction;
import game.Enums.PlayerStatus;

public class SummonSign extends Ground {
    /**
     * Constructor.
     */
    public SummonSign() {
        super('=');
    }

    /**
     * Allows the player to summon
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        if (actor.hasCapability(PlayerStatus.SUMMON)){
            actions.add(new SummonAction());
        }
        return actions;
    }
}
