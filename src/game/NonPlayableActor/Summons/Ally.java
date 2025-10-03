package game.NonPlayableActor.Summons;

import game.Behaviours.AttackBehaviour;
import game.Behaviours.WanderBehaviour;
import game.Enums.NonPlayableType;

public class Ally extends Summons {
    /**
     * Constructor.
     */
    public Ally() {
        super("Ally", 'A', 1);
        this.addCapability(NonPlayableType.ALLY);
        this.behaviours.put(1, new AttackBehaviour());
        this.behaviours.put(2, new WanderBehaviour());
    }

}
