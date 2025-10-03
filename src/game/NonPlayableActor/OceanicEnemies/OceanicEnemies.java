package game.NonPlayableActor.OceanicEnemies;

import game.NonPlayableActor.NonPlayableActor;
import game.Enums.NonPlayableType;
import game.Utils.ResetManager;

public abstract class OceanicEnemies extends NonPlayableActor {
    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public OceanicEnemies(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        this.addCapability(NonPlayableType.OCEANIC);
        ResetManager.getInstance().registerResettable(this);
    }
}
