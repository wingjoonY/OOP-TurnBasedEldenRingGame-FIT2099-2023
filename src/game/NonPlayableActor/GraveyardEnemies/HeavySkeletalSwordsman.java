package game.NonPlayableActor.GraveyardEnemies;

import edu.monash.fit2099.engine.actors.Actor;
import game.Behaviours.*;
import game.Enums.NonPlayableType;
import game.NonPlayableActor.NonPlayableActor;
import game.Enums.PlayerStatus;
import game.Utils.RunesManager;
import game.Weapons.WeaponItems.Grossmesser;
/**
 * A Heavy Skeletal Swordsman that settles in the western graveyards.
 * @author Sam Zachary Chee Hao Yuan
 * @version 1.0
 * @see NonPlayableActor
 * Modified by:
 * Yap Wing Joon
 */
public class HeavySkeletalSwordsman extends GraveyardEnemies {
    /**
     * Constructor for HeavySkeletalSwordsman.
     * @param player Player that will be followed.
     */
    public HeavySkeletalSwordsman(Actor player) {
        super("Heavy Skeletal Swordsman",
                'q',
                153);
        this.addCapability(NonPlayableType.RESPAWNABLE);
        RunesManager.getInstance().createRune(this, 35, 892);
        this.behaviours.put(1, new AOEAttackBehaviour());
        this.behaviours.put(2, new AttackBehaviour());
        this.behaviours.put(3, new FollowBehaviour(player));
        this.behaviours.put(4, new DespawnBehaviour());
        this.behaviours.put(5, new WanderBehaviour());
        this.addWeaponToInventory(new Grossmesser());
    }


}


