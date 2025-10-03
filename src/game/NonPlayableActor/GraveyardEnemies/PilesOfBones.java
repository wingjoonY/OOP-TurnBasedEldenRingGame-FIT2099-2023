package game.NonPlayableActor.GraveyardEnemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Actions.DeathActions.TransformAction;
import game.Behaviours.IdleRespawnBehaviour;
import game.NonPlayableActor.NonPlayableActor;
import game.Interfaces.Respawnable;
import game.Utils.RunesManager;

/**
 *
 * Poor skeleton, hopefully you come back.
 *
 * @author Sam Zachary Chee Hao Yuan
 * @version 1.0
 * @see NonPlayableActor
 * Modified by:
 * Yap Wing Joon
 */
public class PilesOfBones extends GraveyardEnemies implements Respawnable {

    /**
     * number of turns needed for the piles of bones to respawn/transform back
     */
    private int turnsToRespawn = 3;

    /**
     * Actor to be transformed
     */
    private Actor transformTarget;


    /**
     * Constructor for PilesOfBones class.
     * @param transformTarget Actor to be transformed into a pile of bones
     */
    public PilesOfBones(Actor transformTarget) {
        super("Pile of Bones",
                'X',
                1);
        this.transformTarget = transformTarget;
        this.behaviours.put(1, new IdleRespawnBehaviour(this));
        for (WeaponItem weaponItem: transformTarget.getWeaponInventory()){
            this.addWeaponToInventory(weaponItem);
        }
        RunesManager.getInstance().createRune(this,RunesManager.getInstance().getRune(transformTarget).getAmount());
    }

    public int getTurnsToRespawn() {
        return turnsToRespawn;
    }

    @Override
    public void countDown() {
        turnsToRespawn --;
    }

    @Override
    public Action respawn() {
        return new TransformAction(transformTarget);
    }


}
