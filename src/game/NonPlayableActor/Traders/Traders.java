package game.NonPlayableActor.Traders;

import game.Behaviours.IdleBehaviour;
import game.NonPlayableActor.NonPlayableActor;
import game.Enums.NonPlayableType;

public class Traders extends NonPlayableActor {
    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Traders(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        this.addCapability(NonPlayableType.ALLY);
        this.behaviours.put(1, new IdleBehaviour());
    }
}
