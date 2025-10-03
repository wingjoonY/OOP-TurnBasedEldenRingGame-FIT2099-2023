package game.PlayableArchetypes;

import game.Weapons.WeaponItems.Club;
/**
 * The Wretch starting class, has 414 hp and gets a Club.
 * @author Yap Wing Joon
 * @version 1.0
 * @see PlayableCharacter
 */
public class Wretch extends PlayableCharacter {
    /**
     * Constructor for Wretch class.
     */
    public Wretch() {
        super("Tarnished", '@', 414, new Club());
    }
}
