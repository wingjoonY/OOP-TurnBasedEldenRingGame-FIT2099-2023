package game.Actions.DeathActions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.PlayableArchetypes.PlayableCharacter;
import game.Utils.FancyMessage;
import game.Items.Runes;
import game.Utils.RunesManager;

/**
 * Since the player can never truly die, a special class is created to handle the player's "death"
 * @author Sam Zachary Chee Hao Yuan
 * @version 1.0
 * @see Action
 */
public class RespawnPlayerAction extends Action {

    private final PlayableCharacter playableCharacter;

    RunesManager runesManager = RunesManager.getInstance();

    /**
     * Constructor
     * @param playableCharacter the player
     */
    public RespawnPlayerAction(PlayableCharacter playableCharacter){
        this.playableCharacter = playableCharacter;
    }

    /**
     * When executed, drop player's rune at previous location and respawn the player
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return A string
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        Runes runes = runesManager.getRune(playableCharacter);
        Runes dummyRunes = runesManager.getRune(null);
        dummyRunes.setAmount(runes.getAmount());
        playableCharacter.getPreviousLocation().addItem(dummyRunes);
        runes.setAmount(0);
        System.out.println("hi");
        map.moveActor(playableCharacter, playableCharacter.getRespawnPoint());
        System.out.println(FancyMessage.YOU_DIED);
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " respawns at " + playableCharacter.getRespawnPoint().toString();
    }
}
