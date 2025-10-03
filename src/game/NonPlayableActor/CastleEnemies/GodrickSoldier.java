package game.NonPlayableActor.CastleEnemies;

import edu.monash.fit2099.engine.actors.Actor;
import game.Behaviours.AttackBehaviour;
import game.Behaviours.DespawnBehaviour;
import game.Behaviours.FollowBehaviour;
import game.Behaviours.WanderBehaviour;
import game.Utils.RunesManager;
import game.Weapons.WeaponItems.HeavyCrossbow;

public class GodrickSoldier extends CastleEnemies {
    /**
     * Constructor.
     * @param player will be followed.
     */
    public GodrickSoldier(Actor player) {
        super("Godrick Soldier", 'p', 198);
        RunesManager.getInstance().createRune(this, 38, 70);
        this.addWeaponToInventory(new HeavyCrossbow());
        this.behaviours.put(1, new AttackBehaviour());
        this.behaviours.put(2, new FollowBehaviour(player));
        this.behaviours.put(3, new DespawnBehaviour());
        this.behaviours.put(4, new WanderBehaviour());
    }
}
