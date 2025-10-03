package game.Utils;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.Environments.Dirt;
import game.Environments.Floor;
import game.Environments.SiteOfLostGrace;
import game.Environments.SpawningGrounds.Graveyard;
import game.Environments.SpawningGrounds.GustOfWind;
import game.Environments.SpawningGrounds.PuddleOfWater;
import game.Environments.Wall;
import game.GameMap.BossRoom;
import game.GameMap.Limgrave;
import game.GameMap.RoundTableHold;
import game.GameMap.StormveilCastle;
import game.NonPlayableActor.Traders.MerchantKale;
import game.PlayableArchetypes.*;

import java.util.Arrays;
import java.util.List;

/**
 * A map manager class to manage every map in the game
 * Created by:
 * @author Sam Zachary Chee Hao Yuan
 *
 */
public class MapManager {

    /**
     * A static instance of MapManager
     */
    private static MapManager instance = null;

    private MapManager(){}
    /**
     * Gets and instance of MapManager class
     * @return the instance of MapManager class
     */

    public static MapManager getInstance() {
        if (instance == null) {
            instance = new MapManager();
        }
        return instance;
    }

    public void start(World world) {
        Limgrave.processMap(world);
        StormveilCastle.processMap(world);
        RoundTableHold.processMap(world);
        BossRoom.processMap(world);
    }
}
