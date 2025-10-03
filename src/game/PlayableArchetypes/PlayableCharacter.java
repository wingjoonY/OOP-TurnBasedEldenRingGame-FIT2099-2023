package game.PlayableArchetypes;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Actions.DeathActions.ResetAction;
import game.Actions.DeathActions.RespawnPlayerAction;
import game.Items.FlaskOfCrimsonTears;
import game.Enums.PlayerStatus;
import game.Items.RemembranceOfTheGrafted;
import game.Utils.ResetManager;
import game.Interfaces.Resettable;
import game.Utils.RunesManager;
import game.Weapons.RangedWeapon;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing the Player. It implements the Resettable interface.
 * It carries around a club to attack a hostile creature in the Lands Between.
 * @author Adrian Kristanto
 * Modified by: Sam Zachary Chee Hao Yuan
 *
 */
public abstract class PlayableCharacter extends Actor implements Resettable {
	/**
	 * Menu class to print description of actions
	 */
	private final Menu menu = new Menu();

	/**
	 * Ranged weapon inventory
	 */
	private List<RangedWeapon> rangedWeaponsInventory = new ArrayList<>();

	/**
	 * Player's location last turn
	 */
	private Location previousLocation;

	/**
	 * Player's respawn point
	 */
	private Location respawnPoint;

	/**
	 * Player's initial weapon when they were first created
	 */
	private WeaponItem weapon;

	/**
	 * Constructor.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public PlayableCharacter(String name, char displayChar, int hitPoints, WeaponItem weapon) {
		super(name, displayChar, hitPoints);
		this.addItemToInventory(FlaskOfCrimsonTears.getInstance());
		this.addCapability(PlayerStatus.HOSTILE_TO_ENEMY);
		this.addCapability(PlayerStatus.TRADABLE);
		this.addCapability(PlayerStatus.RESTING);
		this.addCapability(PlayerStatus.SUMMON);
		this.addCapability(PlayerStatus.TRAVEL);
		this.weapon = weapon;
		this.addWeaponToInventory(weapon);
		ResetManager.getInstance().registerResettable(this);
		RunesManager.getInstance().createRune(this, 0, 0);
	}

	/**
	 * At each turn, select a valid action to perform.
	 *
	 * @param actions    collection of possible Actions for this Actor
	 * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
	 * @param map        the map containing the Actor
	 * @param display    the I/O object to which messages may be written
	 * @return the valid action that can be performed in that iteration or null if no valid action is found
	 */
	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
		if (!this.isConscious()){
			new ResetAction().execute(this,map);
			RunesManager.getInstance().getRune(null).setLocation(previousLocation);
			new RespawnPlayerAction(this).execute(this, map);
			return new DoNothingAction();
		}
		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();

		this.previousLocation = map.locationOf(this);
		System.out.println("Hit Points: " + this.printHp() + " | Runes: " + RunesManager.getInstance().getRune(this).getAmount());
		ActionList rangedActions;
		// return/print the console menu
		return  menu.showMenu(this, actions, display);
	}

	/**
	 * Get the player's location last turn
	 * @return player's previous location
	 */
	public Location getPreviousLocation() {
		return previousLocation;
	}

	/**
	 * Get the player's respawn point
	 * @return player's respawn point
	 */
	public Location getRespawnPoint() {
		return respawnPoint;
	}

	/**
	 * Reset the player's health points
	 */
	@Override
	public void reset(GameMap map) {
		this.hitPoints = maxHitPoints;
	}

	/**
	 * Set the player's respawn point
	 */
	public void setRespawnPoint(Location location){
		this.respawnPoint = location;
	}

	/**
	 * Get the player's max hp (Created for summon action)
	 * @return player's max hp
	 */
	public int getHp(){
		return getMaxHp();
	}

	/**
	 * Get the player's weapon when they were first created (Created for summon action)
	 * @return player's weapon
	 */
	public WeaponItem getWeapon(){
		return weapon;
	}
}
