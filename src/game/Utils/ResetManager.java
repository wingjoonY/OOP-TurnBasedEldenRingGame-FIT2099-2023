package game.Utils;

import edu.monash.fit2099.engine.positions.GameMap;
import game.Interfaces.Resettable;

import java.util.ArrayList;
import java.util.List;

/**
 * A reset manager class that manages a list of resettables.
 * Created by:
 * @author Adrian Kristanto
 * Modified by: Keith Ong Guo Er
 *
 */
public class ResetManager {
    /**
     * A list of resettables
     */
    private List<Resettable> resettables;
    /**
     * A list of resettables that only resets when the player dies only
     */
    private List<Resettable> specialResettables;
    /**
     * An instance of reset manager
     */
    private static ResetManager instance = null;

    /**
     * Constructor for the ResetManager class
     */
    private ResetManager() {
        this.resettables = new ArrayList<>();
        this.specialResettables = new ArrayList<>();
    }

    /**
     * Resets everything that is resettable on game map
     * @param map the game map
     */
    public void run(GameMap map) {
        for (Resettable resettable : resettables){
            resettable.reset(map);
        }
        for (Resettable resettable : specialResettables){
            resettable.reset(map);
        }
    }

    /**
     * Resets certain resettables on game map (Special Resettables are not reset)
     * @param map the game map
     */
    public void playerRest(GameMap map){
        for (Resettable resettable : resettables){
            resettable.reset(map);
        }
    }

    /**
     * Add resettable into the list of Resettable
     * @param resettable the resettable object
     */
    public void registerResettable(Resettable resettable) {resettables.add(resettable);}

    /**
     * Add resettable into the list of specialResettable
     * @param resettable the resettable object
     */
    public void registerSpecialResettable(Resettable resettable) {specialResettables.add(resettable);}

    /**
     * Remove resettable from list of Resettable
     * @param resettable the resettable object
     */
    public void removeResettable(Resettable resettable) {resettables.remove(resettable);}

    /**
     * Remove resettable from list of specialResettable
     * @param resettable the resettable object
     */
    public void removeSpecialResettable(Resettable resettable) {specialResettables.remove(resettable);}

    /**
     * Retrieve the resettable list
     * @return the list of resettables
     */
    public List<Resettable> getResettables(){
        return resettables;
    }

    /**
     * Retrieve the specialResettable list
     * @return the list of resettables
     */
    public List<Resettable> getSpecialResettables() {
        return specialResettables;
    }

    /**
     * Gets and instance of ResetManager class
     * @return the instance of ResetManager class
     */
    public static ResetManager getInstance() {
        if (instance == null) {
            instance = new ResetManager();
        }
        return instance;
    }
}
