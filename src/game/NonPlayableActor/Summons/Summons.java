package game.NonPlayableActor.Summons;

import game.NonPlayableActor.NonPlayableActor;
import game.Utils.RandomNumberGenerator;
import game.Utils.ResetManager;

public abstract class Summons extends NonPlayableActor {
    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Summons(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        ResetManager.getInstance().registerSpecialResettable(this);

    }
}
