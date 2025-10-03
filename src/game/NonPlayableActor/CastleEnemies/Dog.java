package game.NonPlayableActor.CastleEnemies;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.Behaviours.AttackBehaviour;
import game.Behaviours.DespawnBehaviour;
import game.Behaviours.FollowBehaviour;
import game.Behaviours.WanderBehaviour;
import game.Utils.RunesManager;

public class Dog extends CastleEnemies {
    /**
     * Constructor.
     * @param player Player that will be followed.
     */
    public Dog(Actor player) {
        super("Dog", 'a', 104);
        RunesManager.getInstance().createRune(this, 52, 1390);
        this.behaviours.put(1, new AttackBehaviour());
        this.behaviours.put(2, new FollowBehaviour(player));
        this.behaviours.put(3, new DespawnBehaviour());
        this.behaviours.put(4, new WanderBehaviour());
    }


    /**
     * Dog uses its fangs
     * @return claws
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(101, "bites", 93);
    }

}
