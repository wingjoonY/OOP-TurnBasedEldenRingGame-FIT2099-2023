package game.Weapons;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.PickUpAction;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Enums.PlayerStatus;
import game.PlayableArchetypes.PlayableCharacter;

public abstract class RangedWeapon extends WeaponItem {

    private int range;
    /**
     * Constructor.
     * @param name        name of the item
     * @param displayChar character to use for display when item is on the ground
     * @param damage      amount of damage this weapon does
     * @param verb        verb to use for this weapon, e.g. "hits", "zaps"
     * @param hitRate     the probability/chance to hit the target.
     */
    public RangedWeapon(String name, char displayChar, int damage, String verb, int hitRate, int range) {
        super(name, displayChar, damage, verb, hitRate);
        this.range = range;
        this.addCapability(PlayerStatus.RANGED);
    }
}
