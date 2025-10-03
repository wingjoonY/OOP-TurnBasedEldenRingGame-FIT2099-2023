package game.NonPlayableActor.GustEnemies;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.Behaviours.*;
import game.Utils.RunesManager;

/**
 * BEHOLD, DOG!
 *
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 * Yap Wing Joon
 */
public class LoneWolf extends GustEnemies {

    /**
     * Constructor for LoneWolf class.
     * @param player the player the wolf will follow
     */
    public LoneWolf(Actor player) {
        super("Lone Wolf",
                'h',
                102);
        RunesManager.getInstance().createRune(this, 55, 1470);
        this.behaviours.put(1, new AttackBehaviour());
        this.behaviours.put(2, new FollowBehaviour(player));
        this.behaviours.put(3, new DespawnBehaviour());
        this.behaviours.put(4, new WanderBehaviour());
    }

    /**
     * Wolf uses its claws
     * @return claws
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(97, "bites", 95);
    }

}


