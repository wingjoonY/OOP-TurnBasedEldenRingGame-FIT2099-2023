package game.GameMap;

import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.Environments.*;
import game.Environments.SpawningGrounds.Graveyard;
import game.Environments.SpawningGrounds.GustOfWind;
import game.Environments.SpawningGrounds.PuddleOfWater;
import game.NonPlayableActor.Traders.FingerReaderEnia;

import java.util.Arrays;
import java.util.List;

/**
 * RoundTableHold map
 * @author : Sam Zachary Chee Hao Yuan
 */
public class RoundTableHold {

    private static List<String> roundTableHoldMapString = Arrays.asList(
            "##################",
            "#________________#",
            "#________________#",
            "#________________#",
            "#________________#",
            "#________________#",
            "#________________#",
            "#________________#",
            "#________________#",
            "#________________#",
            "########___#######");

    private static FancyGroundFactory groundFactory = new FancyGroundFactory(new Wall(), new Floor());

    private  static GameMap roundTableHoldMap = new GameMap(groundFactory, roundTableHoldMapString);

    /**
     * Process the map
     * @param world the world
     */
    public static void processMap(World world){
        world.addGameMap(roundTableHoldMap);
        SiteOfLostGrace tableOfLostGrace = new SiteOfLostGrace(roundTableHoldMap,9,5,"Table of Lost Grace");
        roundTableHoldMap.at(9, 5).setGround(tableOfLostGrace);
        roundTableHoldMap.at(9, 10).setGround(new GoldenFogDoor(Limgrave.getLimgraveMap(), 25, 4, "Limgrave"));
        roundTableHoldMap.at(2, 2).addActor(new FingerReaderEnia());
    }

    /**
     * Get the current map
     * @return a GameMap
     */
    public static GameMap getRoundTableHoldMap() {
        return roundTableHoldMap;
    }
}
