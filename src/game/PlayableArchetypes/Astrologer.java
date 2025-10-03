package game.PlayableArchetypes;

import game.Weapons.WeaponItems.AstrologerStaff;

/**
 * The Astrologer starting class, has 396 hp and gets an Astrologer's Staff.
 * @author Sam Zachary Chee Hao Yuan
 * @version 1.0
 * @see PlayableCharacter
 */
public class Astrologer extends PlayableCharacter {
    /**
     * Constructor for Astrologer class
     */
    public Astrologer() {
        super("Tarnished", '@', 396, new AstrologerStaff());
    }
}
