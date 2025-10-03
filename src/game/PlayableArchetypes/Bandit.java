package game.PlayableArchetypes;


import game.Weapons.WeaponItems.GreatKnife;

/**
 * The Bandit starting class, has 414 hp and gets a Great Knife.
 * @author Yap Wing Joon
 * @version 1.0
 * @see PlayableCharacter
 */
public class Bandit extends PlayableCharacter {
    /**
     * Constructor for Bandit class.
     */
    public Bandit() {
        super("Tarnished", '@', 414, new GreatKnife());
    }
}
