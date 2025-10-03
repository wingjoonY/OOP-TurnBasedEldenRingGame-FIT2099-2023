package game.NonPlayableActor.Summons;

import edu.monash.fit2099.engine.actors.Actor;
import game.Behaviours.AttackBehaviour;
import game.Behaviours.FollowBehaviour;
import game.Behaviours.WanderBehaviour;
import game.Enums.NonPlayableType;

public class Invader extends Summons {
    /**
     * Constructor.
     */
    public Invader(Actor player) {
        super("Invader", 'ඞ', 1);
        this.addCapability(NonPlayableType.INVADER);
        this.behaviours.put(1, new AttackBehaviour());
        this.behaviours.put(2, new FollowBehaviour(player));
        this.behaviours.put(3, new WanderBehaviour());
    }
}
