package game.PlayableArchetypes;

import game.Weapons.WeaponItems.Uchigatana;
/**
 * The Samurai starting class, has 455 hp and gets a Uchigatana.
 * @author Yap Wing Joon
 * @version 1.0
 * @see PlayableCharacter
 */
public class Samurai extends PlayableCharacter {
    /**
     * Constructor for Samurai class.
     */
    public Samurai() {
        super("Tarnished", '@', 455, new Uchigatana());
    }
}
